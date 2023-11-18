package me.restonic4.restapi.template;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.holder.RestSound;
import me.restonic4.restapi.sound.SoundRegistry;

import static me.restonic4.restapi.RestApiVariables.MOD_ID;

public class TestSounds {
    public static final RestSound sound = SoundRegistry.RegisterSound(MOD_ID, "sound_test");

    public static void register() {
        SoundRegistry.Register(MOD_ID);

        RestApi.Log("Sounds added");
    }
}
