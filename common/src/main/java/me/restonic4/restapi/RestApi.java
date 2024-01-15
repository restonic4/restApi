package me.restonic4.restapi;

import me.restonic4.restapi.advancement.criterion_trigger.CriterionTriggerRegistry;
import me.restonic4.restapi.block.BlockRegistry;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.sound.SoundRegistry;
import me.restonic4.restapi.template.TestUtil;
import me.restonic4.restapi.template.Testing;

import static me.restonic4.restapi.RestApiVariables.*;

public class RestApi
{
	//VARIABLE GENERATED WITH BUILD.GRADLE
	public static boolean isATestBuild = false;

	public static final String URL_NEW_LOGGER = "https://rest-studio.com/pages/rest_api/util.html#Logger";

	/**
	 * @deprecated New way to log messages into the console here: {@link #URL_NEW_LOGGER}.
	 */
	@Deprecated(since = "0.10", forRemoval = true)
	public static void Log(Object message) {
		API_LOGGER.log(message);
	}

	/**
	 * @deprecated New way to log messages into the console here: {@link #URL_NEW_LOGGER}.
	 */
	@Deprecated(since = "0.10", forRemoval = true)
	public static void Log(Object message, String mod) {
		API_LOGGER.log("[restApi + " + mod + "] " + message);
	}

	public static void NotImplementedError() {
		throw new UnsupportedOperationException("This is not implemented yet! Check the documentation!");
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
		CriterionTriggerRegistry.CreateRegistry(MOD_ID);

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
