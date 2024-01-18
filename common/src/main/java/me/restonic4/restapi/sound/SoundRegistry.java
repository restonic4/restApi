package me.restonic4.restapi.sound;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.holder.RestSound;
import me.restonic4.restapi.sound.RegistryVersions.SoundRegistrySet3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.SoundType;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;

@SuppressWarnings("unchecked")
public class SoundRegistry {
    /**
     * This creates a registry for your mod.
     * @param ModId The mod id.
     */
    public static Object CreateRegistry(String ModId) {
        API_LOGGER.log("Creating sound events registry");

        //1.20 - 1.20.2
        return SoundRegistrySet3.createRegistry(ModId);
    }

    /**
     * Get the registry of sound events.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        //1.20 -> 1.20.2
        return SoundRegistrySet3.getModRegistry(ModId);
    }

    /**
     * This creates a creative tab.
     * @param ModId The mod id.
     * @param SoundId The sound id.
     * @return Returns the sound event as RestSound type.
     */
    public static RestSound RegisterSound(String ModId, String SoundId) {
        RestSound soundHolder = new RestSound();
        soundHolder.setItemHolder(SoundRegistrySet3.registerSound(ModId, SoundId));

        return soundHolder;
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
        SoundRegistrySet3.playSound(player, sound, source, volume, pitch);
    }

    /**
     * This creates a sound type.
     * @param Volume The volume. 0 : 1
     * @param Pitch The pitch. -1 : 1
     * @param BreakSound The sound when it breaks.
     * @param StepSound The sound when you walk on it.
     * @param PlaceSound The sound when you place it.
     * @param HitSound The sound when you start breaking it.
     * @param FallSound The sound when you fall on it.
     * @return Returns the sound type as SoundType.
     */
    public static SoundType CreateCustomSoundType(float Volume, float Pitch, Object BreakSound, Object StepSound, Object PlaceSound, Object HitSound, Object FallSound) {
        return SoundRegistrySet3.createCustomSoundType(Volume, Pitch, BreakSound, StepSound, PlaceSound, HitSound, FallSound);
    }

    /**
     * This registers all of your sound events.
     * @param ModId The mod id.
     */
    public static void Register(String ModId) {
        API_LOGGER.log("Trying to register sound events");

        SoundRegistrySet3.register(ModId);

        API_LOGGER.log("Sound events registered");
    }
}
