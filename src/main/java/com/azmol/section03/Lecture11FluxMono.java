package com.azmol.section03;

import com.azmol.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by azmol on 3/8/2022
 * convert Flux <===> Mono
 */
public class Lecture11FluxMono {

    public static void main(String[] args) {

        // convert Mono => Flux
        var mono = getUserName(1);
        save(Flux.from(mono));

        // convert Flux => Mono
        Flux.range(1, 3)
                .next()
                .subscribe(Util.subscribe("mono subscriber"));
    }

    public static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("Jack");
            case 2 -> Mono.empty();
            default -> Mono.error(new IllegalAccessException("User not found"));
        };
    }

    public static void save(Flux<String> flux) {
        flux.subscribe(Util.subscribe("flux subscriber"));
    }

}
