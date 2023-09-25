package me.restonic4.restapi.item.RegistryVersions;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.DeferredSupplier;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.item.AdvancedItemType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("UnstableApiUsage")
public class ItemRegistrySet1 {//1.20 - 1.20.2
    static List<DeferredRegister<Item>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<Item> DEFAULT;

    public static void createRegistry(String ModId) {
        DeferredRegister<Item> ITEMS = DeferredRegister.create(ModId, Registries.ITEM);

        REGISTRIES.add(ITEMS);
    }

    //Gets the registry for the client's mod, if you didn't create it, it will create one for you located here, in this mod.
    public static DeferredRegister<Item> getModRegistry(String ModId) {
        DeferredRegister<Item> ITEMS = null;

        for (int i = 0; i < REGISTRIES.size(); i++) {
            if (Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), ModId)) {
                ITEMS = REGISTRIES.get(i);
            }

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), RestApi.MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (ITEMS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                createRegistry(RestApi.MOD_ID);
            }

            ITEMS = getModRegistry(RestApi.MOD_ID);
        }

        return ITEMS;
    }

    public static RegistrySupplier<Item> createSimple(String ModId, String ItemId, DeferredSupplier<CreativeModeTab> CreativeTab) {
        Item item;
        Item.Properties properties = new Item.Properties();

        if (CreativeTab != null) {
            item = new Item(properties.arch$tab(CreativeTab));
        }
        else {
            item = new Item(properties);
        }

        final Item finalItem = item;
        return getModRegistry(ModId).register(
                ItemId,
                () -> finalItem
        );
    }

    public static RegistrySupplier<Item> createAdvanced(String ModId, String ItemId, DeferredSupplier<CreativeModeTab> CreativeTab, AdvancedItemType.Type ItemType, String[] Data) {
        Item item;
        Item.Properties properties = new Item.Properties();

        if (CreativeTab != null) {
            properties = properties.arch$tab(CreativeTab);
        }

        switch (ItemType) {
            case SWORD:
                item = new SwordItem(Tiers.valueOf(Data[0]), Integer.parseInt(Data[1]), Float.parseFloat(Data[2]), properties);

            default:
                item = null;
        }

        final Item finalItem = item;
        return getModRegistry(ModId).register(
                ItemId,
                () -> finalItem
        );
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

    public static RegistrySupplier<Item> createFood(String ModId, String ItemId, DeferredSupplier<CreativeModeTab> CreativeTab, FoodProperties FoodProperties) {
        Item item;
        Item.Properties properties = new Item.Properties().food(FoodProperties);

        if (CreativeTab != null) {
            item = new Item(properties.arch$tab(CreativeTab));
        }
        else {
            item = new Item(properties);
        }

        final Item finalItem = item;
        return getModRegistry(ModId).register(
                ItemId,
                () -> finalItem
        );
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
