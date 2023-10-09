package me.restonic4.restapi.item;

import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.item.RegistryVersions.ItemRegistrySet1;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unchecked")
public class ItemRegistry {
    /**
     * This creates a registry for your mod
     * @param ModId Your mod id.
     */
    public static Object CreateRegistry(String ModId) {
        RestApi.Log("Creating item registry", ModId);

        return ItemRegistrySet1.createRegistry(ModId);
    }

    /**
     * Get the registry of item.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        return ItemRegistrySet1.getModRegistry(ModId);
    }

    /**
     * This creates a simple item with or without a creative tab.
     * @param ModId Your mod id.
     * @param ItemId The item id.
     * @param CreativeTab The creative tab or null for nothing.
     * @return Returns the item registered as Object type.
     */
    public static Object CreateSimple(String ModId, String ItemId, Object CreativeTab) {
        RestApi.Log("Creating simple item", ModId);

        return ItemRegistrySet1.createSimple(ModId, ItemId, CreativeTab);
    }

    /**
     * This creates an advanced item, like a sword, axe, shield..
     * @param ModId The mod id.
     * @param ItemId The item id.
     * @param CreativeTab Creative tab/null
     * @param ItemType The item type. Use AdvancedItemType.Type.
     * @param ItemData A string array with the item's data.
     * @return Returns the item as Object type.
     */
    public static Object CreateAdvanced(String ModId, String ItemId, Object CreativeTab, AdvancedItemType ItemType, String[] ItemData) {
        RestApi.Log("Creating advanced item", ModId);

        return ItemRegistrySet1.createAdvanced(ModId, ItemId, CreativeTab, ItemType, ItemData);
    }

    /**
     * This creates a custom item based on a custom class.
     * @param ModId The mod id.
     * @param ItemId The item id.
     * @param CreativeTab The creative tab/null.
     * @param ItemClass Your custom class that extends the Item class.
     * @return Returns your custom item.
     * @param <T> Your class.
     */
    public static <T extends Item> Object CreateCustom(String ModId, String ItemId, Object CreativeTab, T ItemClass) {
        return ItemRegistrySet1.createCustom(ModId, ItemId, CreativeTab, ItemClass);
    }

    public static Object CreateBlockItem(String ModId, Object Block, String BlockId, Object CreativeTab) {
        RestApi.Log("Creating block item", ModId);

        return ItemRegistrySet1.createBlockItem(ModId, Block, BlockId, CreativeTab);
    }

    /**
     * This creates a simple food item.
     * @param ModId The mod id.
     * @param ItemId The item id.
     * @param CreativeTab Creative tab/null.
     * @param Nutrition Nutrition value.
     * @param SaturationMod Saturation value.
     * @return Returns the item registered as Object type.
     */
    public static Object CreateFood(String ModId, String ItemId, Object CreativeTab, int Nutrition, float SaturationMod) {
        RestApi.Log("Creating food item", ModId);

        return ItemRegistrySet1.createFood(ModId, ItemId, CreativeTab, ItemRegistrySet1.createFoodProperties(2, 1, null, 0));
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
     * @return Returns the item registered as Object type.
     */
    public static Object CreateFoodWithEffect(String ModId, String ItemId, Object CreativeTab, int Nutrition, float SaturationMod, Object Effect, float Chance) {
        RestApi.Log("Creating food item with effect", ModId);

        return ItemRegistrySet1.createFood(ModId, ItemId, CreativeTab, ItemRegistrySet1.createFoodProperties(2, 1, Effect, Chance));
    }

    /**
     * Creates an instance of an existing effect.
     * @param EffectType The effect type.
     * @param Duration The duration of the effect in ticks. 20 ticks = 1 second.
     * @param Level The level of the effect.
     * @return Returns the effect as Object type.
     */
    public static Object CreateExistingEffect(Object EffectType, int Duration, int Level) {
        return ItemRegistrySet1.createEffect((MobEffect) EffectType, Duration, Level);
    }

    /**
     * This registers all of your items.
     * @param ModId Your mod id.
     */
    public static void Register(String ModId) {
        RestApi.Log("Trying to register items", ModId);

        ItemRegistrySet1.register(ModId);

        RestApi.Log("Items registered", ModId);
    }
}
