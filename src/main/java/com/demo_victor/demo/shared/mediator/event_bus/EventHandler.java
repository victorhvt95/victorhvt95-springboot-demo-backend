package com.demo_victor.demo.shared.mediator.event_bus;

public interface EventHandler<T extends Event> {
    void handle(T event);
}