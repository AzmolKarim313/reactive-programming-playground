package com.azmol.section01.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    public static final int MAX_REQUESTED = 10;
    public final Faker faker;
    private final Subscriber<? super String> subscriber;
    private boolean isCancelled = false;
    private int count = 0;


    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if (isCancelled) {
            return;
        }

        log.info("Requested {} elements", requested);

        if (requested > MAX_REQUESTED) {
            subscriber.onError(new RuntimeException("Cannot request more than " + MAX_REQUESTED + " elements."));
            this.cancel();
            return;
        }

        for (int i = 0; i < requested && count < MAX_REQUESTED; i++) {
            count++;
            subscriber.onNext(faker.internet().emailAddress());
        }

        if (count == MAX_REQUESTED) {
            log.info("All elements have been requested.");
            subscriber.onComplete();
            this.cancel();
            return;
        }
    }

    @Override
    public void cancel() {
        log.info("Subscription has been cancelled.");
        isCancelled = true;
    }
}
