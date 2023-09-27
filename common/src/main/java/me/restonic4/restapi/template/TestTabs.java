package me.restonic4.restapi.template;

import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import net.minecraft.world.item.CreativeModeTab;

@SuppressWarnings("unchecked")
public class TestTabs {
    public static final RegistrySupplier<CreativeModeTab> tab = (RegistrySupplier<CreativeModeTab>) CreativeTabRegistry.CreateCreativeTab(RestApi.MOD_ID, "test_tab", TestItems.item);

    public static void register() {
        RestApi.Log("Tabs added");
    }
}
