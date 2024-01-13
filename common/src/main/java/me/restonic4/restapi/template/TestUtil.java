package me.restonic4.restapi.template;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.util.AdvancementTrigger;
import net.minecraft.server.level.ServerPlayer;

import static me.restonic4.restapi.RestApiVariables.MOD_ID;

public class TestUtil {
    public static AdvancementTrigger adv1 = new AdvancementTrigger(MOD_ID, "adv1");

    public static void register() {
        adv1.register();

        InteractionEvent.FARMLAND_TRAMPLE.register(
                (world, pos, state, distance, entity) -> {
                    if (entity instanceof ServerPlayer) {
                        if (adv1.hasAdvancement((ServerPlayer) entity)) {
                            RestApi.Log("Dude, stop!");
                        }
                        else {
                            RestApi.Log("Don't do that again!");
                            adv1.grant((ServerPlayer) entity);
                        }
                    }

                    return EventResult.pass();
                }
        );
    }
}
