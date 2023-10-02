package me.restonic4.restapi.sound;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.creative_tab.RegistryVersions.CreativeTabRegistrySet1;
import me.restonic4.restapi.sound.RegistryVersions.SoundRegistrySet1;
import net.minecraft.world.entity.player.Player;

public class SoundRegistry {
    /**
     * This creates a registry for your mod.
     * @param ModId The mod id.
     */
    public static Object CreateRegistry(String ModId) {
        RestApi.Log("Creating sound events registry", ModId);

        //1.20 - 1.20.2
        return SoundRegistrySet1.createRegistry(ModId);
    }

    /**
     * Get the registry of sound events.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        //1.20 -> 1.20.2
        return SoundRegistrySet1.getModRegistry(ModId);
    }

    /**
     * This creates a creative tab.
     * @param ModId The mod id.
     * @param SoundId The sound id.
     * @return Returns the sound event as Object type.
     */
    public static Object RegisterSound(String ModId, String SoundId) {
        //1.20 - 1.20.2
        return SoundRegistrySet1.registerSound(ModId, SoundId);
    }

    /**
     * This plays a sound.
     * @param player The player.
     * @param sound The sound.
     * @param source The source. Ambient, players, music...
     * @param volume The volume 0 to 1.
     * @param pitch The pitch -1 to 1. 0 = normal.
     */
    public static void PlaySound(Player player, Object sound, Object source, float volume, float pitch) {
        SoundRegistrySet1.playSound(player, sound, source, volume, pitch);
    }

    /**
     * This registers all of your sound events.
     * @param ModId The mod id.
     */
    public static void Register(String ModId) {
        RestApi.Log("Trying to register sound events", ModId);

        //1.20 - 1.20.2
        SoundRegistrySet1.register(ModId);

        RestApi.Log("Sound events registered", ModId);
    }
}
