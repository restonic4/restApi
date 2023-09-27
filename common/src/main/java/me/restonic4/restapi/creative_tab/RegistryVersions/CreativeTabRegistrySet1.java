package me.restonic4.restapi.creative_tab.RegistryVersions;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarBuilder;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CreativeTabRegistrySet1 {
    static List<DeferredRegister<CreativeModeTab>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<CreativeModeTab> DEFAULT;

    public static Object createRegistry(String ModId) {
        DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(ModId, Registries.CREATIVE_MODE_TAB);
        TABS.register();

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

    public static RegistrySupplier<CreativeModeTab> createCreativeTab(String ModId, String TabId, Object ItemAsIcon) {
        DeferredRegister<CreativeModeTab> TABS = getModRegistry(ModId);

        //Item itemForIcon;

        /*if (ItemAsIcon instanceof RegistrySupplier<?>) {
            itemForIcon = ((RegistrySupplier<Item>) ItemAsIcon).get();
        } else if (ItemAsIcon instanceof Item) {
            itemForIcon = (Item) ItemAsIcon;
        }
        else {
            itemForIcon = (Item) ItemAsIcon;
        }*/
        RestApi.Log("WAOS");
        RestApi.Log(ItemAsIcon);
        RestApi.Log("WAOS");

        //Item finalItemForIcon = itemForIcon;
        RegistrySupplier<CreativeModeTab> TAB =
                TABS.register(
                        TabId,
                        () -> CreativeTabRegistry.create(
                                Component.translatable("itemGroup." + TabId),
                                () -> new ItemStack(((RegistrySupplier<Item>) ItemAsIcon).get())
                        )
                );

        return TAB;
        /*RestApi.Log("ITEM OBJECT ----->");
        RestApi.Log(ItemAsIcon);
        RestApi.Log(ItemAsIcon instanceof RegistrySupplier<?>);
        RegistrySupplier<Item> thing = (RegistrySupplier<Item>) ItemAsIcon;
        RestApi.Log(thing);
        RestApi.Log(thing.isPresent());
        RestApi.Log(thing.getId());
        RestApi.Log(thing.getRegistrar());
        String itemId = thing.getId().toString().replaceAll(ModId + ":", "");
        ResourceLocation loc = new ResourceLocation(ModId, itemId);
        RestApi.Log(itemId);
        RestApi.Log(loc);
        RestApi.Log(thing.getRegistrar().get(loc));
        RestApi.Log(thing.getRegistrar().contains(loc));
        Item a = ((RegistrySupplier<Item>) ItemAsIcon).getRegistrar().get(loc);
        RestApi.Log(a);
        thing.getRegistrar().register(loc, () -> new Item(new Item.Properties().durability(10).defaultDurability(5)));
        Item b = thing.getRegistrar().get(loc);
        RestApi.Log(b);
        //RegistrySupplier<Item> wo = ;
        //Registries.ITEM.
        //Item wowowo = Objects.requireNonNull(thing).get();
        //RestApi.Log(wowowo);
        RestApi.Log("<----- ITEM OBJECT");

        return null;*/
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
