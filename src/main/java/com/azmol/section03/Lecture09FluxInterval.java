package com.azmol.section03;

import com.azmol.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture09FluxInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(500))
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.subscribe());

        Util.sleep(5);
    }

}
