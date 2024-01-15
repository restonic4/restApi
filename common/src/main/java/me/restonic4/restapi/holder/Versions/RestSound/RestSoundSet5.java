package me.restonic4.restapi.holder.Versions.RestSound;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.sounds.SoundEvent;

public class RestSoundSet5 {
    private RegistrySupplier<SoundEvent> itemHolder;

    public RestSoundSet5() {}

    public void setItemHolder(RegistrySupplier<SoundEvent> itemHolder) {
        this.itemHolder = itemHolder;
    }

    public RegistrySupplier<SoundEvent> get() {
        return itemHolder;
    }
}
