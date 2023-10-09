package me.restonic4.restapi.creative_tab.RegistryVersions;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.item.ItemRegistry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CreativeTabRegistrySet2 {
    static List<DeferredRegister<CreativeModeTab>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<CreativeModeTab> DEFAULT;

    public static Object createRegistry(String ModId) {
        return null;
    }

    public static DeferredRegister<CreativeModeTab> getModRegistry(String ModId) {
        return null;
    }

    public static Object createCreativeTab(String ModId, String TabId, String ItemId) {
        DeferredRegister<CreativeModeTab> TABS = getModRegistry(ModId);

        RegistrySupplier<Item> itemSupplier = ((DeferredRegister<Item>) ItemRegistry.GetRegistry(ModId)).getRegistrar().delegate(new ResourceLocation(ModId, ItemId));

        return dev.architectury.registry.CreativeTabRegistry.create(
                new ResourceLocation(ModId, TabId),
                () -> new ItemStack(itemSupplier.get())
        );
    }

    public static void register(String ModId) {
        RestApi.Log("Loaded");
    }
}
