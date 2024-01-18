package me.restonic4.restapi.item;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.holder.RestCreativeTab;
import me.restonic4.restapi.holder.RestItem;
import me.restonic4.restapi.item.RegistryVersions.ItemRegistrySet3;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;

@SuppressWarnings("unchecked")
public class ItemRegistry {
    /**
     * This creates a registry for your mod
     * @param ModId Your mod id.
     */
    public static Object CreateRegistry(String ModId) {
        API_LOGGER.log("Creating item registry");

        return ItemRegistrySet3.createRegistry(ModId);
    }

    /**
     * Get the registry of item.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        return ItemRegistrySet3.getModRegistry(ModId);
    }

    /**
     * This creates a simple item with or without a creative tab.
     * @param ModId Your mod id.
     * @param ItemId The item id.
     * @param CreativeTab The creative tab or null for nothing.
     * @return Returns the item registered as RestItem type.
     */
    public static RestItem CreateSimple(String ModId, String ItemId, RestCreativeTab CreativeTab) {
        API_LOGGER.log("Creating simple item");

        RestItem itemHolder = new RestItem();
        itemHolder.setItemHolder(ItemRegistrySet3.createSimple(ModId, ItemId, CreativeTab));

        return itemHolder;
    }

    /**
     * This creates a custom item based on a custom class.
     * @param ModId The mod id.
     * @param ItemId The item id.
     * @param ItemClass Your custom class that extends the Item class in a supplier.
     * @return Returns your custom item.
     * @param <T> Your class.
     */
    public static <T extends Item> RestItem CreateCustom(String ModId, String ItemId, Supplier<T> ItemClass) {
        RestItem itemHolder = new RestItem();
        itemHolder.setItemHolder(ItemRegistrySet3.createCustom(ModId, ItemId, ItemClass));

        return itemHolder;
    }

    public static RestItem CreateBlockItem(String ModId, Object Block, String BlockId, RestCreativeTab CreativeTab) {
        API_LOGGER.log("Creating block item");

        RestItem itemHolder = new RestItem();
        itemHolder.setItemHolder(ItemRegistrySet3.createBlockItem(ModId, Block, BlockId, CreativeTab));

        return itemHolder;
    }

    /**
     * This creates a simple food item.
     * @param ModId The mod id.
     * @param ItemId The item id.
     * @param CreativeTab Creative tab/null.
     * @param Nutrition Nutrition value.
     * @param SaturationMod Saturation value.
     * @return Returns the item registered as RestItem type.
     */
    public static RestItem CreateFood(String ModId, String ItemId, RestCreativeTab CreativeTab, int Nutrition, float SaturationMod) {
        API_LOGGER.log("Creating food item");

        RestItem itemHolder = new RestItem();
        itemHolder.setItemHolder(ItemRegistrySet3.createFood(ModId, ItemId, CreativeTab, ItemRegistrySet3.createFoodProperties(Nutrition, SaturationMod, null, 0)));

        return itemHolder;
    }

    /**
     * This created a food item with effects.
     * @param ModId The mod id.
     * @param ItemId The item id.
     * @param CreativeTab Creative tab/null.
     * @param Nutrition Nutrition value.
     * @param SaturationMod Saturation value.
     * @param Effect The effect. Can be created with ItemRegistry.CreateExistingEffect.
     * @param Chance The chance of getting the effect. 1 = always, 0 = never, 0.5 = 50%
     * @return Returns the item registered as RestItem type.
     */
    public static RestItem CreateFoodWithEffect(String ModId, String ItemId, RestCreativeTab CreativeTab, int Nutrition, float SaturationMod, Object Effect, float Chance) {
        API_LOGGER.log("Creating food item with effect");

        RestItem itemHolder = new RestItem();
        itemHolder.setItemHolder(ItemRegistrySet3.createFood(ModId, ItemId, CreativeTab, ItemRegistrySet3.createFoodProperties(Nutrition, SaturationMod, Effect, Chance)));

        return itemHolder;
    }

    /**
     * Creates an instance of an existing effect.
     * @param EffectType The effect type.
     * @param Duration The duration of the effect in ticks. 20 ticks = 1 second.
     * @param Level The level of the effect.
     * @return Returns the effect as Object type.
     */
    public static MobEffectInstance CreateExistingEffect(Object EffectType, int Duration, int Level) {
        return ItemRegistrySet3.createEffect((MobEffect) EffectType, Duration, Level);
    }

    /**
     * This registers all of your items.
     * @param ModId Your mod id.
     */
    public static void Register(String ModId) {
        API_LOGGER.log("Trying to register items");

        ItemRegistrySet3.register(ModId);

        API_LOGGER.log("Items registered");
    }
}
