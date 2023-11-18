package me.restonic4.restapi.sound;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class RestSoundType extends SoundType {
    private final RegistrySupplier<SoundEvent> breakSound;
    private final RegistrySupplier<SoundEvent> stepSound;
    private final RegistrySupplier<SoundEvent> placeSound;
    private final RegistrySupplier<SoundEvent> hitSound;
    private final RegistrySupplier<SoundEvent> fallSound;

    public RestSoundType(float volumeIn, float pitchIn, RegistrySupplier<SoundEvent> breakSoundIn, RegistrySupplier<SoundEvent> stepSoundIn, RegistrySupplier<SoundEvent> placeSoundIn, RegistrySupplier<SoundEvent> hitSoundIn, RegistrySupplier<SoundEvent> fallSoundIn)
    {
        super(volumeIn, pitchIn, null, null, null, null, null);
        this.breakSound = breakSoundIn;
        this.stepSound = stepSoundIn;
        this.placeSound = placeSoundIn;
        this.hitSound = hitSoundIn;
        this.fallSound = fallSoundIn;
    }

    @NotNull
    @Override
    public SoundEvent getBreakSound()
    {
        return breakSound.get();
    }

    @NotNull
    @Override
    public SoundEvent getStepSound()
    {
        return stepSound.get();
    }

    @NotNull
    @Override
    public SoundEvent getPlaceSound()
    {
        return placeSound.get();
    }

    @NotNull
    @Override
    public SoundEvent getHitSound()
    {
        return hitSound.get();
    }

    @NotNull
    @Override
    public SoundEvent getFallSound()
    {
        return fallSound.get();
    }
}
