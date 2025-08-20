package com.azmol.section02;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lecture08MonoFuture {
    private static final Logger log = LoggerFactory.getLogger(Lecture08MonoFuture.class);

    public static void main(String[] args) {

        Mono.fromFuture(getName())
                .subscribe(Util.subscribe());

        Util.sleep(2);

    }

    public static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> {
            log.info("Generated dynamic name:");
            return Util.faker().name().fullName();
        });
    }
}
