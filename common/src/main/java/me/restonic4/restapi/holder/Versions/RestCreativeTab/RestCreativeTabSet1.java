package me.restonic4.restapi.holder.Versions.RestCreativeTab;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.CreativeModeTab;

public class RestCreativeTabSet1 {
    private RegistrySupplier<CreativeModeTab> itemHolder;

    public RestCreativeTabSet1() {}

    public void setItemHolder(RegistrySupplier<CreativeModeTab> itemHolder) {
        this.itemHolder = itemHolder;
    }

    public RegistrySupplier<CreativeModeTab> get() {
        return itemHolder;
    }
}
