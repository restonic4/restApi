package me.restonic4.restapi.fabric;

import me.restonic4.restapi.RestApi;
import net.fabricmc.api.ModInitializer;

public class RestApiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        RestApi.init();
    }
}