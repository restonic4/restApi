package me.restonic4.restapi.sound.RegistryVersions;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.holder.RestSound;
import me.restonic4.restapi.sound.RestSoundType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.SoundType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static me.restonic4.restapi.RestApiVariables.MOD_ID;

@SuppressWarnings({"UnstableApiUsage", "unchecked"})
public class SoundRegistrySet2 {
    static List<DeferredRegister<SoundEvent>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<SoundEvent> DEFAULT;

    public static Object createRegistry(String ModId) {
        DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ModId, Registries.SOUND_EVENT);

        REGISTRIES.add(SOUNDS);

        return SOUNDS;
    }

    //Gets the registry for the client's mod, if you didn't create it, it will create one for you located here, in this mod.
    public static DeferredRegister<SoundEvent> getModRegistry(String ModId) {
        DeferredRegister<SoundEvent> SOUNDS = null;

        for (int i = 0; i < REGISTRIES.size(); i++) {
            if (Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), ModId)) {
                SOUNDS = REGISTRIES.get(i);
            }

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (SOUNDS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                RestApi.Log("Registry not found, try creating one with SoundRegistry.CreateRegistry(ModID).");

                createRegistry(MOD_ID);
            }

            SOUNDS = getModRegistry(MOD_ID);
        }

        return SOUNDS;
    }

    public static RegistrySupplier<SoundEvent> registerSound(String ModId, String SoundId) {
        ResourceLocation id = new ResourceLocation(ModId, SoundId);
        return getModRegistry(ModId).register(SoundId, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void playSound(Player player, Object sound, Object source, float volume, float pitch) {
        RegistrySupplier<SoundEvent> soundFixed = (sound instanceof RestSound) ? ((RestSound)sound).get() : (RegistrySupplier<SoundEvent>) sound;
        SoundSource soundSourceFixed = (SoundSource) source;

        player.level.playSound(player, player.getX(), player.getY(), player.getZ(), soundFixed.get(), soundSourceFixed, volume, pitch);
    }

    public static SoundType createCustomSoundType(float volume, float pitch, Object breakSound, Object stepSound, Object placeSound, Object hitSound, Object fallSound) {
        RegistrySupplier<SoundEvent> fixedBreakSound = (breakSound instanceof RestSound) ? ((RestSound)breakSound).get() : (RegistrySupplier<SoundEvent>) breakSound;
        RegistrySupplier<SoundEvent> fixedStepSound = (stepSound instanceof RestSound) ? ((RestSound)stepSound).get() : (RegistrySupplier<SoundEvent>) stepSound;
        RegistrySupplier<SoundEvent> fixedPlaceSound = (placeSound instanceof RestSound) ? ((RestSound)placeSound).get() : (RegistrySupplier<SoundEvent>) placeSound;
        RegistrySupplier<SoundEvent> fixedHitSound = (hitSound instanceof RestSound) ? ((RestSound)hitSound).get() : (RegistrySupplier<SoundEvent>) hitSound;
        RegistrySupplier<SoundEvent> fixedFallSound = (fallSound instanceof RestSound) ? ((RestSound)fallSound).get() : (RegistrySupplier<SoundEvent>) fallSound;

        return new RestSoundType(volume, pitch, fixedBreakSound, fixedStepSound, fixedPlaceSound, fixedHitSound, fixedFallSound);
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
