package me.restonic4.restapi.advancement.criterion_trigger.RegistryVersions;

import dev.architectury.registry.registries.DeferredRegister;
import me.restonic4.restapi.RestApi;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.resources.ResourceLocation;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;

public class CriterionTriggerRegistrySet4 {
    public static Object createRegistry(String ModId) {
        return null;
    }

    //Gets the registry for the client's mod, if you didn't create it, it will create one for you located here, in this mod.
    public static DeferredRegister<CriterionTrigger<?>> getModRegistry(String ModId) {
        return null;
    }

    public static CriterionTrigger<?> create(String ModId, String ItemId) {
        return CriteriaTriggers.register(new PlayerTrigger(new ResourceLocation(ModId, ItemId)));
    }

    public static void register(String ModId) {
        API_LOGGER.log("Advancement triggers loaded without Registries");
    }
}
