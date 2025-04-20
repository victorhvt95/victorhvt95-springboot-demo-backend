package com.demo_victor.demo.shared.mediator.simple_mediator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SimpleMediator implements Mediator {
    private final Map<Class<?>, Handler<?, ?>> handlers = new HashMap<>();

    public <TRequest extends Request<TResult>, TResult> void registerHandler(Class<TRequest> type,
            Handler<TRequest, TResult> handler) {
        handlers.put(type, handler);
    }

    @SuppressWarnings("unchecked")
    public <T> T send(Request<T> request) {
        Handler<Request<T>, T> handler = (Handler<Request<T>, T>) handlers.get(request.getClass());
        if (handler == null)
            throw new RuntimeException("No handler registered for " + request.getClass());
        return handler.handle(request);
    }
}