package me.restonic4.restapi.item.RegistryVersions;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.DeferredSupplier;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("UnstableApiUsage")
public class ItemRegistrySet1 {//1.20 - 1.20.2
    static List<DeferredRegister<Item>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<Item> DEFAULT;

    public static void createRegistry(String ModId) {
        DeferredRegister<Item> ITEMS = DeferredRegister.create(ModId, Registries.ITEM);

        REGISTRIES.add(ITEMS);
    }

    //Gets the registry for the client's mod, if you didn't create it, it will create one for you located here, in this mod.
    static DeferredRegister<Item> getModRegistry(String ModId) {
        DeferredRegister<Item> ITEMS = null;

        for (int i = 0; i < REGISTRIES.size(); i++) {
            if (Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), ModId)) {
                ITEMS = REGISTRIES.get(i);
            }

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), RestApi.MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (ITEMS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                createRegistry(RestApi.MOD_ID);
            }

            ITEMS = getModRegistry(RestApi.MOD_ID);
        }

        return ITEMS;
    }

    public static RegistrySupplier<Item> createSimple(String ModId, String ItemId, DeferredSupplier<CreativeModeTab> CreativeTab) {
        Item item;

        if (CreativeTab != null) {
            item = new Item(new Item.Properties().arch$tab(CreativeTab));
        }
        else {
            item = new Item(new Item.Properties());
        }

        final Item finalItem = item;
        return getModRegistry(ModId).register(
                ItemId,
                () -> finalItem
        );
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
