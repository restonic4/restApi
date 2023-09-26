package me.restonic4.restapi.creative_tab.RegistryVersions;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CreativeTabRegistrySet1 {
    static List<DeferredRegister<CreativeModeTab>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<CreativeModeTab> DEFAULT;

    public static void createRegistry(String ModId) {
        DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(ModId, Registries.CREATIVE_MODE_TAB);

        REGISTRIES.add(TABS);
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

    public static RegistrySupplier<CreativeModeTab> createCreativeTab(String ModId, String TabId, Object ItemAsIcon) {
        DeferredRegister<CreativeModeTab> TABS = getModRegistry(ModId);

        Item itemForIcon;

        if (ItemAsIcon instanceof RegistrySupplier<?>) {
            itemForIcon = ((RegistrySupplier<Item>) ItemAsIcon).get();
        } else if (ItemAsIcon instanceof Item) {
            itemForIcon = (Item) ItemAsIcon;
        }
        else {
            itemForIcon = (Item) ItemAsIcon;
        }

        Item finalItemForIcon = itemForIcon;
        RegistrySupplier<CreativeModeTab> TAB =
                TABS.register(
                        TabId,
                        () -> CreativeTabRegistry.create(
                                Component.translatable("itemGroup." + TabId),
                                () -> new ItemStack(finalItemForIcon)
                        )
                );

        return TAB;
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
