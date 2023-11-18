package me.restonic4.restapi.holder.Versions.RestCreativeTab;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.CreativeModeTab;

public class RestCreativeTabSet4 {
    private CreativeTabRegistry.TabSupplier itemHolder;

    public RestCreativeTabSet4() {}

    public void setItemHolder(CreativeTabRegistry.TabSupplier itemHolder) {
        this.itemHolder = itemHolder;
    }

    public CreativeTabRegistry.TabSupplier get() {
        return itemHolder;
    }
}
