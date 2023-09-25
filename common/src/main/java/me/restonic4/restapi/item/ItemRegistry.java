package me.restonic4.restapi.item;

import dev.architectury.registry.registries.DeferredRegister;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.item.RegistryVersions.ItemRegistrySet1;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import dev.architectury.registry.registries.DeferredSupplier;

public class ItemRegistry {

    /**
     * This creates a registry for your mod
     * @param ModId Your mod id.
     */
    public static void CreateRegistry(String ModId) {
        //1.20 - 1.20.2
        ItemRegistrySet1.createRegistry(ModId);
    }

    /**
     * This creates a simple item with or without a creative tab.
     * @param ModId Your mod id.
     * @param ItemId The item id.
     * @param CreativeTab The creative tab or null for nothing.
     * @return Returns the item registered.
     */
    public static Object CreateSimple(String ModId, String ItemId, Object CreativeTab) {
        //1.20 - 1.20.2
        return ItemRegistrySet1.createSimple(ModId, ItemId, (DeferredSupplier<CreativeModeTab>)CreativeTab);
    }

    /**
     * This registers all of your items.
     * @param ModId Your mod id.
     */
    public static void Register(String ModId) {
        RestApi.Log("Trying to register items", ModId);

        //1.20 - 1.20.2
        ItemRegistrySet1.register(ModId);

        RestApi.Log("Items registered", ModId);
    }
}
