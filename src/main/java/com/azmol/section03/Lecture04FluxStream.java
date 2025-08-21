package com.azmol.section03;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lecture04FluxStream {
    private static final Logger log = LoggerFactory.getLogger(Lecture04FluxStream.class);

    public static void main(String[] args) {
        var list = List.of("hello", "world", "!");
        var stream = list.stream();

        // stream supplier for multiple subscribers
        var flux = Flux.fromStream(() -> stream);

        flux
            .subscribe(Util.subscribe("sub1"));

        flux
            .subscribe(Util.subscribe("sub2"));
    }
}
