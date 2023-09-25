package me.restonic4.restapi.forge;

import dev.architectury.platform.forge.EventBuses;
import me.restonic4.restapi.RestApi;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RestApi.MOD_ID)
public class RestApiForge {
    public RestApiForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(RestApi.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        RestApi.init();
    }
}