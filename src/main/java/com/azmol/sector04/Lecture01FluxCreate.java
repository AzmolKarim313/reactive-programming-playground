package com.azmol.sector04;

import com.azmol.common.Util;
import reactor.core.publisher.Flux;

public class Lecture01FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("bangladesh"));
            fluxSink.complete();
        })
                .subscribe(Util.subscribe("country finder"));

    }

}
