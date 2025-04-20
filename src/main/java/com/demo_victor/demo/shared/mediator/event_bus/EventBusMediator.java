package com.demo_victor.demo.shared.mediator.event_bus;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBusMediator {
    private final Map<Class<?>, List<EventHandler<?>>> listeners = new ConcurrentHashMap<>();

    public <T extends Event> void register(Class<T> eventType, EventHandler<T> handler) {
        listeners
                .computeIfAbsent(eventType, e -> new CopyOnWriteArrayList<>())
                .add(handler);
    }

    @SuppressWarnings("unchecked")
    public <T extends Event> void send(T event) {
        List<EventHandler<?>> handlers = listeners.getOrDefault(event.getClass(), List.of());

        for (EventHandler<?> handler : handlers) {
            try {
                ((EventHandler<T>) handler).handle(event);
            } catch (Exception ex) {
                System.err.println("Error al manejar evento: " + event.getClass().getSimpleName());
                ex.printStackTrace(); // o usa tu logger preferido
            }
        }
    }
}
