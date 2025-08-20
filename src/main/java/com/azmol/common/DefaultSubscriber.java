package com.azmol.common;

import com.azmol.section01.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {
    private static final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);

    private final String name;

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        log.info("Subscriber: {} received: {}", this.name, item);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("Subscriber: {} error:", this.name, throwable);
    }

    @Override
    public void onComplete() {
        log.info("Subscriber: {} complete!", this.name);
    }
}
