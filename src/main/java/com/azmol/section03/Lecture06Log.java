package com.azmol.section03;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lecture06Log {
    private static final Logger log = LoggerFactory.getLogger(Lecture06Log.class);

    public static void main(String[] args) {

        Flux.range(1, 3)
                .log("range2map")
                .map(i -> Util.faker().name().fullName())
                .log("map2subscribe")
                .subscribe(Util.subscribe());

    }
}
