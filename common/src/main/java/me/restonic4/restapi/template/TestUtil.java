package me.restonic4.restapi.template;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import me.restonic4.restapi.advancement.criterion_trigger.CriterionTriggerRegistry;
import me.restonic4.restapi.holder.RestAdvancement;
import net.minecraft.server.level.ServerPlayer;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;
import static me.restonic4.restapi.RestApiVariables.MOD_ID;

public class TestUtil {
    public static final RestAdvancement adv1 = CriterionTriggerRegistry.CreateAdvancementTrigger(MOD_ID, "adv1");

    public static void register() {
        API_LOGGER.log("aaa");

        CriterionTriggerRegistry.Register(MOD_ID);

        API_LOGGER.log("no way ->");
        API_LOGGER.log(adv1);

        InteractionEvent.FARMLAND_TRAMPLE.register(
                (world, pos, state, distance, entity) -> {
                    API_LOGGER.log(adv1.get());

                    if (entity instanceof ServerPlayer serverPlayer) {
                        if (adv1.hasAdvancement(serverPlayer)) {
                            serverPlayer.teleportTo(serverPlayer.position().x, serverPlayer.position().y + 10, serverPlayer.position().z);
                        }
                        else {
                            adv1.award(serverPlayer);
                        }

                    }

                    return EventResult.pass();
                }
        );
    }
}
