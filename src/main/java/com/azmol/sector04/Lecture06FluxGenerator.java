package com.azmol.sector04;

import com.azmol.common.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lecture06FluxGenerator {

    public static void main(String[] args) {

        AtomicReference<String> name = new AtomicReference<>("");

        Flux.generate(synchronousSink -> {
            name.set(Util.faker().country().name());
           synchronousSink.next(name);
        })
                .takeUntil(item -> item.toString().equalsIgnoreCase("canada"))
                .subscribe(Util.subscribe());

    }

}
