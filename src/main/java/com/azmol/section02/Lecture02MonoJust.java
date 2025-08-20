package com.azmol.section02;

import com.azmol.section01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lecture02MonoJust {

    public static final Logger log = LoggerFactory.getLogger(Lecture02MonoJust.class);

    public static void main(String[] args) {

        var mono = Mono.just("Azmol");
        var subscribe = new SubscriberImpl();
        mono.subscribe(subscribe);
        subscribe.getSubscription().request(10);

    }

}
