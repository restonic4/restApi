package me.restonic4.restapi.template;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.sound.SoundRegistry;

public class TestSounds {
    public static final Object sound = SoundRegistry.RegisterSound(RestApi.MOD_ID, "sound_test");

    public static void register() {
        SoundRegistry.Register(RestApi.MOD_ID);

        RestApi.Log("Sounds added");
    }
}
