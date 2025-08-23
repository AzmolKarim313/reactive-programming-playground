package com.azmol.sectpr05;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture04Delay {
    private static final Logger log = LoggerFactory.getLogger(Lecture04Delay.class);

    public static void main(String[] args) {

        Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscribe());

        Util.sleep(5);

    }

}
