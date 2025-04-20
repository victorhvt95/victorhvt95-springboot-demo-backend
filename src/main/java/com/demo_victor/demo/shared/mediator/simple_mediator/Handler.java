package com.demo_victor.demo.shared.mediator.simple_mediator;

public interface Handler<TRequest extends Request<TResult>, TResult> {
    TResult handle(TRequest request);
}