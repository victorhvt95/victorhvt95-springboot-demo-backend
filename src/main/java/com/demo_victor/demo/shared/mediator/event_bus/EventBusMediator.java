package com.demo_victor.demo.shared.mediator.event_bus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBusMediator {
    private final Map<Class<?>, List<EventHandler<?>>> listeners = new HashMap<>();

    public <T extends Event> void register(Class<T> eventType, EventHandler<T> handler) {
        listeners.computeIfAbsent(eventType, e -> new ArrayList<>()).add(handler);
    }

    @SuppressWarnings("unchecked")
    public <T extends Event> void send(T event) {
        List<EventHandler<?>> handlers = listeners.getOrDefault(event.getClass(), Collections.emptyList());
        for (EventHandler handler : handlers) {
            ((EventHandler<T>) handler).handle(event);
        }
    }
}