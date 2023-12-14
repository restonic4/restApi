package me.restonic4.restapi.holder.Versions.RestPOIType;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class RestPOITypeSet4 {
    private RegistrySupplier<PoiType> poiHolder;

    public RestPOITypeSet4() {}

    public void setPOITypeHolder(RegistrySupplier<PoiType> poiHolder) {
        this.poiHolder = poiHolder;
    }

    public RegistrySupplier<PoiType> get() {
        return poiHolder;
    }
}
