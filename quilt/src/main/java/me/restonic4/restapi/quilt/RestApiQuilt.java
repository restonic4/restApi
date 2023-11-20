package me.restonic4.restapi.quilt;

import me.restonic4.restapi.RestApi;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class RestApiQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        RestApi.init();
    }
}