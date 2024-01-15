package me.restonic4.restapi.item.RegistryVersions;

import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.DeferredSupplier;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.holder.RestCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static me.restonic4.restapi.RestApiVariables.*;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class ItemRegistrySet3 {
    static List<DeferredRegister<Item>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<Item> DEFAULT;

    public static Object createRegistry(String ModId) {
        DeferredRegister<Item> ITEMS = DeferredRegister.create(ModId, Registries.ITEM);

        REGISTRIES.add(ITEMS);

        return ITEMS;
    }

    //Gets the registry for the client's mod, if you didn't create it, it will create one for you located here, in this mod.
    public static DeferredRegister<Item> getModRegistry(String ModId) {
        DeferredRegister<Item> ITEMS = null;

        for (int i = 0; i < REGISTRIES.size(); i++) {
            if (Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), ModId)) {
                ITEMS = REGISTRIES.get(i);
            }

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (ITEMS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                API_LOGGER.log("Registry not found, try creating one with ItemRegistry.CreateRegistry(ModID).");

                createRegistry(MOD_ID);
            }

            ITEMS = getModRegistry(MOD_ID);
        }

        return ITEMS;
    }

    public static RegistrySupplier<Item> createSimple(String ModId, String ItemId, RestCreativeTab CreativeTab) {
        Item.Properties properties = new Item.Properties();

        if (CreativeTab != null) {
            properties = properties.arch$tab(CreativeTab.get());
        }

        Item.Properties finalProperties = properties;
        return getModRegistry(ModId).register(
                ItemId,
                () -> new Item(finalProperties)
        );
    }

    public static <T extends Item> RegistrySupplier<T> createCustom(String ModId, String ItemId, Supplier<T> itemSupplier) {
        return getModRegistry(ModId).register(
                ItemId,
                itemSupplier
        );
    }

    public static <T extends Block> RegistrySupplier<Item> createBlockItem(String ModId, Object toReturn, String blockId, RestCreativeTab CreativeTab) {
        Item.Properties properties = new Item.Properties();

        if (CreativeTab != null) {
            properties = properties.arch$tab(CreativeTab.get());
        }

        Item.Properties finalProperties = properties;
        return registerBlockItemInDesiredPlatform(
                ModId,
                new ResourceLocation(ModId, blockId),
                () -> new BlockItem(((RegistrySupplier<T>) toReturn).get(), finalProperties)
        );
    }

    public static <T extends Item> RegistrySupplier<T> registerBlockItemInDesiredPlatform(String ModId, ResourceLocation path, Supplier<T> itemSupplier) {
        if (Platform.isForgeLike()) {
            return getModRegistry(ModId).register(path.getPath(), itemSupplier);
        }
        return getModRegistry(ModId).getRegistrar().register(path, itemSupplier);
    }

    public static MobEffectInstance createEffect(MobEffect Effect, int Ticks, int Level) {
        return new MobEffectInstance(Effect,Ticks,Level);
    }

    public static FoodProperties createFoodProperties(int Nutrition, float SaturationMod, Object Effect, float Chance) {
        FoodProperties.Builder foodBuilder = new FoodProperties.Builder();

        if (Effect != null) {
            foodBuilder = foodBuilder.effect((MobEffectInstance) Effect, Chance);
        }

        return foodBuilder.nutrition(Nutrition).saturationMod(SaturationMod).build();
    }

    public static RegistrySupplier<Item> createFood(String ModId, String ItemId, RestCreativeTab CreativeTab, FoodProperties FoodProperties) {
        Item.Properties properties = new Item.Properties().food(FoodProperties);

        if (CreativeTab != null) {
            properties = properties.arch$tab(CreativeTab.get());
        }

        Item.Properties finalProperties = properties;
        return getModRegistry(ModId).register(
                ItemId,
                () -> new Item(finalProperties)
        );
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}

