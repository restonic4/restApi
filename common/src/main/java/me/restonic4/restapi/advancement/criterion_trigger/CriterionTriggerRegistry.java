package me.restonic4.restapi.advancement.criterion_trigger;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.advancement.criterion_trigger.RegistryVersions.CriterionTriggerRegistrySet3;
import me.restonic4.restapi.holder.RestAdvancement;
import net.minecraft.resources.ResourceLocation;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;

public class CriterionTriggerRegistry {
    /**
     * This creates a registry for your mod
     * @param ModId Your mod id.
     */
    public static Object CreateRegistry(String ModId) {
        API_LOGGER.log("Creating criterion_trigger registry");

        return CriterionTriggerRegistrySet3.createRegistry(ModId);
    }

    /**
     * Get the registry of criterion_trigger.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        return CriterionTriggerRegistrySet3.getModRegistry(ModId);
    }

    /**
     * This creates an advancement trigger.
     * @param ModId The mod id.
     * @param AdvancementId The advancement id.
     * @return Returns your custom advancement trigger.
     */
    public static RestAdvancement CreateAdvancementTrigger(String ModId, String AdvancementId) {
        RestAdvancement advancementHolder = new RestAdvancement();

        advancementHolder.setCriterionHolder(CriterionTriggerRegistrySet3.create(ModId, AdvancementId));
        advancementHolder.setResourceLocation(new ResourceLocation(ModId, AdvancementId));

        return advancementHolder;
    }

    /**
     * This registers all of your advancement triggers.
     * @param ModId Your mod id.
     */
    public static void Register(String ModId) {
        API_LOGGER.log("Trying to register advancement triggers");

        CriterionTriggerRegistrySet3.register(ModId);

        API_LOGGER.log("Advancement triggers registered");
    }
}
