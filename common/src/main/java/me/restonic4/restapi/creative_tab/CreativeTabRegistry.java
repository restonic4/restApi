package me.restonic4.restapi.creative_tab;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.creative_tab.RegistryVersions.CreativeTabRegistrySet3;
import me.restonic4.restapi.holder.RestCreativeTab;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;

public class CreativeTabRegistry {
    /**
     * This creates a registry for your mod.
     * @param ModId The mod id.
     */
    public static Object CreateRegistry(String ModId) {
        API_LOGGER.log("Creating creative tab registry");

        return CreativeTabRegistrySet3.createRegistry(ModId);
    }

    /**
     * Get the registry of creative tabs.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        return CreativeTabRegistrySet3.getModRegistry(ModId);
    }

    /**
     * This creates a creative tab.
     * @param ModId The mod id.
     * @param TabId The tab id.
     * @param ItemId The item id for the icon.
     * @return Returns the creative tab as Object type.
     */
    public static RestCreativeTab CreateCreativeTab(String ModId, String TabId, String ItemId) {
        RestCreativeTab creativeTabHolder = new RestCreativeTab();
        creativeTabHolder.setItemHolder(CreativeTabRegistrySet3.createCreativeTab(ModId, TabId, ItemId));

        return creativeTabHolder;
    }

    /**
     * This registers all of your creative tabs.
     * @param ModId The mod id.
     */
    public static void Register(String ModId) {
        API_LOGGER.log("Trying to register creative tabs");

        CreativeTabRegistrySet3.register(ModId);

        API_LOGGER.log("Creative tabs registered");
    }
}
