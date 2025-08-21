package com.azmol.section03;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lecture01FluxJust {
    private static final Logger log = LoggerFactory.getLogger(Lecture01FluxJust.class);

    public static void main(String[] args) {

        Flux.just(1, 2, 3, 4, 5, "Md. Azmol Karim")
                .subscribe(Util.subscribe());

    }
}
