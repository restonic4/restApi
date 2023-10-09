package me.restonic4.restapi.template;

import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import net.minecraft.world.item.CreativeModeTab;

@SuppressWarnings("unchecked")
public class TestTabs {
    public static final Object tab = CreativeTabRegistry.CreateCreativeTab(
            RestApi.MOD_ID,
            "test_tab",
            "test_item");

    public static void register() {
        CreativeTabRegistry.Register(RestApi.MOD_ID);

        RestApi.Log("Tabs added");
    }
}
