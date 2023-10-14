package me.restonic4.restapi.sound.RegistryVersions;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
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

@SuppressWarnings({"UnstableApiUsage", "unchecked"})
public class SoundRegistrySet3 {
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

    public static SoundType createCustomSoundType(float volume, float pitch, Object breakSound, Object stepSound, Object placeSound, Object hitSound, Object fallSound) {
        Supplier<SoundEvent> fixedBreakSound = (Supplier<SoundEvent>) breakSound;
        Supplier<SoundEvent> fixedStepSound = (Supplier<SoundEvent>) stepSound;
        Supplier<SoundEvent> fixedPlaceSound = (Supplier<SoundEvent>) placeSound;
        Supplier<SoundEvent> fixedHitSound = (Supplier<SoundEvent>) hitSound;
        Supplier<SoundEvent> fixedFallSound = (Supplier<SoundEvent>) fallSound;

        return new RestSoundType(volume, pitch, fixedBreakSound, fixedStepSound, fixedPlaceSound, fixedHitSound, fixedFallSound);

        /*RegistrySupplier<SoundEvent> breakSoundFixed = (RegistrySupplier<SoundEvent>) breakSound;

        RestApi.Log("_____________________________");

        String id = breakSoundFixed.toString().split("@")[1].split(":")[1];
        RestApi.Log(id);
        RestApi.Log(breakSoundFixed.getRegistrar().get(new ResourceLocation(ModId, id)));
        RestApi.Log(breakSoundFixed.getKey());
        RestApi.Log(breakSoundFixed.getRegistrarManager().get(breakSoundFixed.getRegistryKey()));//hmmmmm

        DeferredRegister<SoundEvent> reg = (DeferredRegister<SoundEvent>) SoundRegistry.GetRegistry(ModId);

        RestApi.Log("_____________________________");

        RestApi.Log(reg);
        RestApi.Log(reg.getRegistrar().get(new ResourceLocation(ModId, id)));
        RestApi.Log(reg.getRegistrarManager().get(breakSoundFixed.getRegistryKey()));//HMMMMMMMMMMMMMM, pero no

        RestApi.Log(reg.getRegistrarManager().get(breakSoundFixed.getRegistryKey()).get(new ResourceLocation(ModId, id)));

        RestApi.Log("_____________________________");

        RestApi.Log(breakSoundFixed.hashCode());
        RestApi.Log(reg.getRegistrar().byRawId(breakSoundFixed.hashCode()));

        RestApi.Log("_____________________________");

        RegistrySupplier<SoundEvent> waos = ((DeferredRegister<SoundEvent>) SoundRegistry.GetRegistry(ModId)).getRegistrar().delegate(new ResourceLocation(ModId, id));
        RestApi.Log(waos);
        RestApi.Log(waos.get());

        RestApi.Log("_____________________________");
        RestApi.Log(breakSoundFixed);
        RestApi.Log(breakSoundFixed.isPresent());
        RestApi.Log(breakSoundFixed.getRegistryId());
        //RestApi.Log(breakSoundFixed.get());

        RestApi.Log("_____________________________");

        RestApi.Log(reg.getRegistrar().contains(new ResourceLocation(ModId, id)));

        ResourceKey<SoundEvent> key = reg.getRegistrar().delegate(new ResourceLocation(ModId, id)).getKey();
        ResourceKey<Registry<SoundEvent>> key2 = reg.getRegistrar().delegate(new ResourceLocation(ModId, id)).getRegistryKey();

        RestApi.Log(key);
        RestApi.Log(key2);
        RestApi.Log(reg.getRegistrarManager().get(key2));

        Registrar<SoundEvent> yup = reg.getRegistrarManager().get(key2);
        RestApi.Log(yup.get(new ResourceLocation(ModId, id)));

        RestApi.Log("_____________________________");

        ResourceKey<SoundEvent> key3 = breakSoundFixed.getKey();
        ResourceKey<Registry<SoundEvent>> key4 = breakSoundFixed.getRegistryKey();

        RestApi.Log(key3);
        RestApi.Log(key4);

        Registrar<SoundEvent> yup2 = reg.getRegistrarManager().get(key4);
        RestApi.Log(yup2.get(new ResourceLocation(ModId, id)));

        return new SoundType(volume, pitch, breakSoundFixed.get(), breakSoundFixed.get(), breakSoundFixed.get(), breakSoundFixed.get(), breakSoundFixed.get());

        Registrar<SoundEvent> registrar = ((DeferredRegister<SoundEvent>) SoundRegistry.GetRegistry(ModId)).getRegistrar();

        RegistrySupplier<SoundEvent> breakSoundFixed = registrar.delegate(new ResourceLocation(ModId, breakSound));
        RegistrySupplier<SoundEvent> stepSoundFixed = registrar.delegate(new ResourceLocation(ModId, stepSound));
        RegistrySupplier<SoundEvent> placeSoundFixed = registrar.delegate(new ResourceLocation(ModId, placeSound));
        RegistrySupplier<SoundEvent> hitSoundFixed = registrar.delegate(new ResourceLocation(ModId, hitSound));
        RegistrySupplier<SoundEvent> fallSoundFixed = registrar.delegate(new ResourceLocation(ModId, fallSound));

        RestApi.Log("_____________________________");
        RestApi.Log(breakSoundFixed);
        RestApi.Log(stepSoundFixed);
        RestApi.Log(placeSoundFixed);
        RestApi.Log(hitSoundFixed);
        RestApi.Log(fallSoundFixed);

        RestApi.Log(fallSoundFixed.getRegistrar());
        RestApi.Log(fallSoundFixed.isPresent());

        return new SoundType(volume, pitch, breakSoundFixed.get(), stepSoundFixed.get(), placeSoundFixed.get(), hitSoundFixed.get(), fallSoundFixed.get());

        Registrar<SoundEvent> registrar = ((DeferredRegister<SoundEvent>) SoundRegistry.GetRegistry(ModId)).getRegistrar();

        return new SoundType(
                volume,
                pitch,
                registrar.delegate(new ResourceLocation(ModId, breakSound)).get(),
                registrar.delegate(new ResourceLocation(ModId, stepSound)).get(),
                registrar.delegate(new ResourceLocation(ModId, placeSound)).get(),
                registrar.delegate(new ResourceLocation(ModId, hitSound)).get(),
                registrar.delegate(new ResourceLocation(ModId, fallSound)).get()
        );

        RegistrySupplier<SoundEvent> breakSoundFixed = (RegistrySupplier<SoundEvent>) breakSound;
        RegistrySupplier<SoundEvent> stepSoundFixed = (RegistrySupplier<SoundEvent>) stepSound;
        RegistrySupplier<SoundEvent> placeSoundFixed = (RegistrySupplier<SoundEvent>) placeSound;
        RegistrySupplier<SoundEvent> hitSoundFixed = (RegistrySupplier<SoundEvent>) hitSound;
        RegistrySupplier<SoundEvent> fallSoundFixed = (RegistrySupplier<SoundEvent>) fallSound;

        RestApi.Log("_____________________________");
        RestApi.Log(breakSoundFixed);
        RestApi.Log(stepSoundFixed);
        RestApi.Log(placeSoundFixed);
        RestApi.Log(hitSoundFixed);
        RestApi.Log(fallSoundFixed);

        return new SoundType(volume, pitch, breakSoundFixed.get(), stepSoundFixed.get(), placeSoundFixed.get(), hitSoundFixed.get(), fallSoundFixed.get());*/
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
