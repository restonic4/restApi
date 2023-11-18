package me.restonic4.restapi;

import me.restonic4.restapi.block.BlockRegistry;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.sound.SoundRegistry;
import me.restonic4.restapi.template.Testing;

import static me.restonic4.restapi.RestApiVariables.*;

public class RestApi
{
	//VARIABLE GENERATED WITH BUILD.GRADLE
	public static boolean isATestBuild = false;

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

	public static boolean CheckObject(Object object) {
		Log(object);
		return (object != null);
	}

	/**
	 * Executed when the mod/api starts
	 */
	public static void init() {
		Log("Api starting.");

		ItemRegistry.CreateRegistry(MOD_ID);
		BlockRegistry.CreateRegistry(MOD_ID);
		CreativeTabRegistry.CreateRegistry(MOD_ID);
		SoundRegistry.CreateRegistry(MOD_ID);

		Log("Default registries created");

		if (isATestBuild) {
			Log("THIS VERSION OF THE API IS FOR TESTING, IF YOU SEE THIS, THEN TELL THE DEV ABOUT THIS.");
			Testing.init();
		}
		else {
			Log("Loading API without testing classes");
		}
	}
}
