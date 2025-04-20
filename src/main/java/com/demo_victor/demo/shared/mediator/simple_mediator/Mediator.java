package com.demo_victor.demo.shared.mediator.simple_mediator;

public interface Mediator {
    <R> R send(Request<R> command);
}
