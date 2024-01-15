package me.restonic4.restapi.POIType;

import me.restonic4.restapi.POIType.RegistryVersions.POITypesRegistrySet1;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.holder.RestPOIType;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;

public class POITypeRegistry {
    /**
     * This creates a registry for your mod
     * @param ModId Your mod id.
     */
    public static Object CreateRegistry(String ModId) {
        API_LOGGER.log("Creating POIType registry");

        RestApi.NotImplementedError();

        return POITypesRegistrySet1.createRegistry(ModId);
    }

    /**
     * Get the registry of POIType.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        RestApi.NotImplementedError();

        return POITypesRegistrySet1.getModRegistry(ModId);
    }

    /**
     * This creates a POIType.
     * @param ModId Your mod id.
     * @param POIType_id The POIType id.
     * @param block The block to use as a POI.
     * @param MaxTickets Max villager ammount that can use the POI.
     * @param ValidRange Range to get the POI.
     * @return Returns the item registered as RestItem type.
     */
    public static RestPOIType Create(String ModId, String POIType_id, Block block, int MaxTickets, int ValidRange) {
        API_LOGGER.log("Creating POIType");

        RestApi.NotImplementedError();

        RestPOIType poiHolder = new RestPOIType();
        poiHolder.setPOITypeHolder(POITypesRegistrySet1.create(ModId, POIType_id, block, MaxTickets, ValidRange));

        return poiHolder;
    }

    /**
     * This registers all of your items.
     * @param ModId Your mod id.
     */
    public static void Register(String ModId) {
        API_LOGGER.log("Trying to register items");

        RestApi.NotImplementedError();

        POITypesRegistrySet1.register(ModId);

        API_LOGGER.log("Items registered");
    }
}
