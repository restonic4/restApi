package me.restonic4.restapi.sound.RegistryVersions;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.template.TestSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("UnstableApiUsage")
public class SoundRegistrySet1 {
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

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), RestApi.MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (SOUNDS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                RestApi.Log("Registry not found, try creating one with SoundRegistry.CreateRegistry(ModID).");

                createRegistry(RestApi.MOD_ID);
            }

            SOUNDS = getModRegistry(RestApi.MOD_ID);
        }

        return SOUNDS;
    }

    public static Object registerSound(String ModId, String SoundId) {
        ResourceLocation id = new ResourceLocation(ModId, SoundId);
        return getModRegistry(ModId).register(SoundId, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void playSound(Player player, Object sound, Object source, float volume, float pitch) {
        RegistrySupplier<SoundEvent> soundFixed = (RegistrySupplier<SoundEvent>) sound;
        SoundSource soundSourceFixed = (SoundSource) source;

        player.level().playSound(player, player.getX(), player.getY(), player.getZ(), soundFixed.get(), soundSourceFixed, volume, pitch);
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
