package me.restonic4.restapi.event.RegistryVersions;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import me.restonic4.restapi.event.EventTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class EventRegistrySet1 {
    public static void registerEvent(EventTypes eventType) {
        switch (eventType) {
            case ENTITY_HURT: entityHurt();
            default: error();
        }
    }

    static void entityHurt() {
        EntityEvent.LIVING_HURT.register((LivingEntity entity, DamageSource source, float amount) -> {
            return EventResult.interruptFalse();
        });
    }

    static void error() {
        throw new IllegalStateException("You tried to register a non existing event.");
    }
}
