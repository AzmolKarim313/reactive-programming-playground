package com.azmol.section03;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lecture05FluxRange {
    private static final Logger log = LoggerFactory.getLogger(Lecture05FluxRange.class);

    public static void main(String[] args) {

        var flux = Flux.range(1, 10);

        flux
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.subscribe());

    }

}
