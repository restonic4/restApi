package me.restonic4.restapi.POIType.RegistryVersions;

import com.google.common.collect.ImmutableSet;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.restonic4.restapi.RestApiVariables.MOD_ID;

public class POITypesRegistrySet4 {
    static List<DeferredRegister<PoiType>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<PoiType> DEFAULT;

    public static Object createRegistry(String ModId) {
        DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ModId, Registries.POINT_OF_INTEREST_TYPE);

        REGISTRIES.add(POI_TYPES);

        return POI_TYPES;
    }

    //Gets the registry for the client's mod, if you didn't create it, it will create one for you located here, in this mod.
    public static DeferredRegister<PoiType> getModRegistry(String ModId) {
        DeferredRegister<PoiType> POI_TYPES = null;

        for (int i = 0; i < REGISTRIES.size(); i++) {
            if (Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), ModId)) {
                POI_TYPES = REGISTRIES.get(i);
            }

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (POI_TYPES == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                RestApi.Log("Registry not found, try creating one with POITypesRegistry.CreateRegistry(ModID).");

                createRegistry(MOD_ID);
            }

            POI_TYPES = getModRegistry(MOD_ID);
        }

        return POI_TYPES;
    }

    public static RegistrySupplier<PoiType> create(String ModId, String poi_id, Block block, int maxTickets, int validRange) {
        return getModRegistry(ModId).register(poi_id, () -> new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()),maxTickets, validRange));
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
