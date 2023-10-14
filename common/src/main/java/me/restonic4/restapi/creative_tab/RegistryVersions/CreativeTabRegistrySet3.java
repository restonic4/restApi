package me.restonic4.restapi.creative_tab.RegistryVersions;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.item.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CreativeTabRegistrySet3 {
    static List<DeferredRegister<CreativeModeTab>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<CreativeModeTab> DEFAULT;

    public static Object createRegistry(String ModId) {
        DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(ModId, Registries.CREATIVE_MODE_TAB);

        REGISTRIES.add(TABS);

        return TABS;
    }

    public static DeferredRegister<CreativeModeTab> getModRegistry(String ModId) {
        DeferredRegister<CreativeModeTab> TABS = null;

        for (int i = 0; i < REGISTRIES.size(); i++) {
            if (Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), ModId)) {
                TABS = REGISTRIES.get(i);
            }

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), RestApi.MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (TABS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                RestApi.Log("Registry not found, try creating one with CreativeTabRegistry.CreateRegistry(ModID).");

                createRegistry(RestApi.MOD_ID);
            }

            TABS = getModRegistry(RestApi.MOD_ID);
        }

        return TABS;
    }

    public static RegistrySupplier<CreativeModeTab> createCreativeTab(String ModId, String TabId, String ItemId) {
        DeferredRegister<CreativeModeTab> TABS = getModRegistry(ModId);

        RegistrySupplier<Item> itemSupplier = ((DeferredRegister<Item>) ItemRegistry.GetRegistry(ModId)).getRegistrar().delegate(new ResourceLocation(ModId, ItemId));

        RegistrySupplier<CreativeModeTab> TAB =
                TABS.register(
                        TabId,
                        () -> CreativeTabRegistry.create(
                                Component.translatable("itemGroup." + ModId + "." + TabId),
                                () -> new ItemStack(itemSupplier.get())
                        )
                );

        return TAB;
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
