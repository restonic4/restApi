package me.restonic4.restapi.neoforge;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.RestApiVariables;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(RestApiVariables.MOD_ID)
public class RestApiNeoForge {

	public RestApiNeoForge(IEventBus modEventBus) {
		RestApi.init();
	}
}
