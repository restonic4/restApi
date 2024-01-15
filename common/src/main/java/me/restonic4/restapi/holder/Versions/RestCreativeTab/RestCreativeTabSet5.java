package me.restonic4.restapi.holder.Versions.RestCreativeTab;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.CreativeModeTab;

public class RestCreativeTabSet5 {
    private RegistrySupplier<CreativeModeTab> itemHolder;

    public RestCreativeTabSet5() {}

    public void setItemHolder(RegistrySupplier<CreativeModeTab> itemHolder) {
        this.itemHolder = itemHolder;
    }

    public RegistrySupplier<CreativeModeTab> get() {
        return itemHolder;
    }
}
