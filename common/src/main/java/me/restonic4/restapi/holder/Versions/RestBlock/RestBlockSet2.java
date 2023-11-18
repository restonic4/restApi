package me.restonic4.restapi.holder.Versions.RestBlock;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;

public class RestBlockSet2<T extends Block>{
    private RegistrySupplier<T> blockHolder;

    public RestBlockSet2() {}

    public void setItemHolder(RegistrySupplier<T> blockHolder) {
        this.blockHolder = blockHolder;
    }

    public RegistrySupplier<T> get() {
        return blockHolder;
    }
}
