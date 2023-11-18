package me.restonic4.restapi.template;

import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import me.restonic4.restapi.holder.RestCreativeTab;
import net.minecraft.world.item.CreativeModeTab;

import static me.restonic4.restapi.RestApiVariables.MOD_ID;

@SuppressWarnings("unchecked")
public class TestTabs {
    public static final RestCreativeTab tab = CreativeTabRegistry.CreateCreativeTab(
            MOD_ID,
            "test_tab",
            "test_item");

    public static void register() {
        CreativeTabRegistry.Register(MOD_ID);

        RestApi.Log("Tabs added");
    }
}
