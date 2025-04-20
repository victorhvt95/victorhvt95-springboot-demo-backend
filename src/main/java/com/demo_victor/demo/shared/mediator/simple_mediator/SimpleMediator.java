package com.demo_victor.demo.shared.mediator.simple_mediator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class SimpleMediator implements Mediator {
    private final Map<Class<?>, Handler<?, ?>> handlers = new ConcurrentHashMap<>();

    public <TRequest extends Request<TResult>, TResult> void registerHandler(
            Class<TRequest> type, Handler<TRequest, TResult> handler) {
        handlers.put(type, handler);
    }

    @SuppressWarnings("unchecked")
    public <T> T send(Request<T> request) {
        Handler<Request<T>, T> handler = (Handler<Request<T>, T>) handlers.get(request.getClass());
        if (handler == null) {
            throw new IllegalArgumentException(
                    "No handler registered for request type: " + request.getClass().getName());
        }
        return handler.handle(request);
    }
}
