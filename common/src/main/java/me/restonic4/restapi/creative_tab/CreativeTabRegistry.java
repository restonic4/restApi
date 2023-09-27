package me.restonic4.restapi.creative_tab;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.creative_tab.RegistryVersions.CreativeTabRegistrySet1;

public class CreativeTabRegistry {
    /**
     * This creates a registry for your mod.
     * @param ModId The mod id.
     */
    public static Object CreateRegistry(String ModId) {
        RestApi.Log("Creating creative tab registry", ModId);
        //1.20 - 1.20.2
        return CreativeTabRegistrySet1.createRegistry(ModId);

        //RestApi.Log("Creative tab registry created", ModId);
    }

    /**
     * This creates a creative tab.
     * @param ModId The mod id.
     * @param TabId The tab id.
     * @param Item The item for the icon.
     * @return Returns the creative tab as Object type.
     */
    public static Object CreateCreativeTab(String ModId, String TabId, Object Item) {
        //1.20 - 1.20.2
        return CreativeTabRegistrySet1.createCreativeTab(ModId, TabId, Item);
    }

    /**
     * This registers all of your creative tabs.
     * @param ModId The mod id.
     */
    public static void Register(String ModId) {
        RestApi.Log("Trying to register creative tabs", ModId);

        //1.20 - 1.20.2
        CreativeTabRegistrySet1.register(ModId);

        RestApi.Log("Creative tabs registered", ModId);
    }
}
