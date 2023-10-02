package me.restonic4.restapi.event;

import me.restonic4.restapi.event.RegistryVersions.EventRegistrySet1;

import java.util.EventListener;

public class EventRegistry {
    public static void RegisterEvent(EventTypes eventType, EventListener listener) {
        EventRegistrySet1.registerEvent(eventType);
    }
}
