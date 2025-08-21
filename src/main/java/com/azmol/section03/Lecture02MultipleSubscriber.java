package com.azmol.section03;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lecture02MultipleSubscriber {
    private static final Logger log = LoggerFactory.getLogger(Lecture02MultipleSubscriber.class);

    public static void main(String[] args) {
        var flux = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        log.info("Subscriber: A");
        flux.subscribe(Util.subscribe("A"));
        log.info("Subscriber: B");
        flux.subscribe(Util.subscribe("b"));
        log.info("Subscriber: C");
        flux
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .subscribe(Util.subscribe("C"));
    }
}
