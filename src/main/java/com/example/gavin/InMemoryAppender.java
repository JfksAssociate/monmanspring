package com.example.gavin;

import ch.qos.logback.core.AppenderBase;

import java.util.concurrent.LinkedBlockingQueue;

public class InMemoryAppender<E> extends AppenderBase<E> {
    private static final LinkedBlockingQueue<String> logQueue = new LinkedBlockingQueue<>(1000);

    @Override
    protected void append(E eventObject) {
        if (!isStarted()) {
            return;
        }
        logQueue.offer(eventObject.toString());
    }

    public static LinkedBlockingQueue<String> getLogQueue() {
        return logQueue;
    }
}

