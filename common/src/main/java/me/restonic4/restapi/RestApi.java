package me.restonic4.restapi;

import dev.architectury.registry.registries.DeferredSupplier;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.item.ItemRegistry;
import net.minecraft.world.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestApi
{
	public static final String MOD_ID = "restapi";
	public static final Logger LOGGER = LogManager.getLogger("restApi");

	/**
	 * This logs a message in the console.
	 * @param message Message shown in the console.
	 */
	public static void Log(Object message) {
		LOGGER.info("[restApi] " + message);
	}

	/**
	 * This logs a message in the console.
	 * @param message Message shown in the console.
	 * @param mod This shows in the console your mod id.
	 */
	public static void Log(Object message, String mod) {
		LOGGER.info("[restApi + " + mod + "] " + message);
	}

	/**
	 * Executed when the mod/api starts
	 */
	public static void init() {
		Log("Api started");

		ItemRegistry.CreateRegistry(MOD_ID);
		Log("Default registry created");

		RegistrySupplier<Item> item = ((RegistrySupplier<Item>) ItemRegistry.CreateSimple(MOD_ID, "test_item", null));

		ItemRegistry.Register(MOD_ID);

		Log("Default testing item created");
	}
}
