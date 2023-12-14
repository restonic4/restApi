package me.restonic4.restapi.holder.Versions.RestPOIType;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class RestPOITypeSet2 {
    private RegistrySupplier<PoiType> poiHolder;

    public RestPOITypeSet2() {}

    public void setPOITypeHolder(RegistrySupplier<PoiType> poiHolder) {
        this.poiHolder = poiHolder;
    }

    public RegistrySupplier<PoiType> get() {
        return poiHolder;
    }
}
