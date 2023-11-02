package me.restonic4.restapi.forge;

import dev.architectury.platform.forge.EventBuses;
import me.restonic4.restapi.RestApi;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static me.restonic4.restapi.RestApiVariables.MOD_ID;

@Mod(MOD_ID)
public class RestApiForge {
    public RestApiForge() {
        EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        RestApi.init();
    }
}