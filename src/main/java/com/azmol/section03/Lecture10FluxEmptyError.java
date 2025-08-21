package com.azmol.section03;

import com.azmol.common.Util;
import reactor.core.publisher.Flux;

public class Lecture10FluxEmptyError {

    public static void main(String[] args) {
        Flux.empty()
                .subscribe(Util.subscribe());

        Util.sleep(2);

        Flux.error(new RuntimeException("Exception from publisher!"))
                .subscribe(Util.subscribe());
    }

}
