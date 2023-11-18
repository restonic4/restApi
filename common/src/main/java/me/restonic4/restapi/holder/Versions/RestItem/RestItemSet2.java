package me.restonic4.restapi.holder.Versions.RestItem;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

public class RestItemSet2<T extends Item> {
    private RegistrySupplier<T> itemHolder;

    public RestItemSet2() {}

    public void setItemHolder(RegistrySupplier<T> itemHolder) {
        this.itemHolder = itemHolder;
    }

    public RegistrySupplier<T> get() {
        return itemHolder;
    }
}
