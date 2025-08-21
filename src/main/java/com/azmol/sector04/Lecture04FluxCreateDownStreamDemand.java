package com.azmol.sector04;

import com.azmol.common.Util;
import com.azmol.section01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lecture04FluxCreateDownStreamDemand {
    private static final Logger log = LoggerFactory.getLogger(Lecture04FluxCreateDownStreamDemand.class);

    public static void main(String[] args) {
//        earlyBird();
        proceedOnDemand();
    }

    public static void earlyBird() {
        var subscribe = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
                    for (int i = 0; i < 10; i++) {
                        var name = Util.faker().name().fullName();
                        fluxSink.next(name);
                        log.info("Emitted name " + name);
                    }
                    fluxSink.complete();
                })
                .subscribe(subscribe);

        Util.sleep(2);
        subscribe.getSubscription().request(2);
        Util.sleep(2);
        subscribe.getSubscription().request(2);
        Util.sleep(2);
        subscribe.getSubscription().cancel();

    }

    public static void proceedOnDemand() {
        var subscribe = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
                    fluxSink.onRequest(request -> {
                        for (int i = 0; i < request; i++) {
                            var name = Util.faker().name().fullName();
                            fluxSink.next(name);
                            log.info("Emitted name " + name);
                        }
                        fluxSink.complete();
                    });
                    fluxSink.onCancel(() -> log.info("Subscription canceled!"));
                })
                .subscribe(subscribe);

        Util.sleep(2);
        subscribe.getSubscription().request(2);
        Util.sleep(2);
        subscribe.getSubscription().request(2);
        Util.sleep(2);
        subscribe.getSubscription().cancel();
    }
}
