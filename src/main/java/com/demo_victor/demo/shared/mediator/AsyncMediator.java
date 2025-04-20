package com.demo_victor.demo.shared.mediator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class AsyncMediator {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public <T> CompletableFuture<T> send(Supplier<T> task) {
        return CompletableFuture.supplyAsync(task, executor);
    }
}