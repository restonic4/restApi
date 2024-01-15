package me.restonic4.restapi.advancement.criterion_trigger.RegistryVersions;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;
import static me.restonic4.restapi.RestApiVariables.MOD_ID;

public class CriterionTriggerRegistrySet5 {
    static List<DeferredRegister<CriterionTrigger<?>>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<CriterionTrigger<?>> DEFAULT;

    public static Object createRegistry(String ModId) {
        DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = DeferredRegister.create(ModId, Registries.TRIGGER_TYPE);

        REGISTRIES.add(CRITERION_TRIGGERS);

        return CRITERION_TRIGGERS;
    }

    //Gets the registry for the client's mod, if you didn't create it, it will create one for you located here, in this mod.
    public static DeferredRegister<CriterionTrigger<?>> getModRegistry(String ModId) {
        DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = null;

        for (int i = 0; i < REGISTRIES.size(); i++) {
            if (Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), ModId)) {
                CRITERION_TRIGGERS = REGISTRIES.get(i);
            }

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (CRITERION_TRIGGERS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                API_LOGGER.log("Registry not found, try creating one with CriterionTriggerRegistry.CreateRegistry(ModID).");

                createRegistry(MOD_ID);
            }

            CRITERION_TRIGGERS = getModRegistry(MOD_ID);
        }

        return CRITERION_TRIGGERS;
    }

    public static RegistrySupplier<CriterionTrigger<?>> create(String ModId, String ItemId) {
        return getModRegistry(ModId).register(
                new ResourceLocation(ModId, ItemId),
                () -> new ImpossibleTrigger()
        );
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
