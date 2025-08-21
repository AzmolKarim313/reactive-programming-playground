package com.azmol.sector04;

import com.azmol.common.Util;
import com.azmol.sector04.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Lecture02FluxCreateRefactor {

    public static void main(String[] args) {

        var generator = new NameGenerator();
        var flux = Flux.create(generator);

        flux.subscribe(Util.subscribe());

        for (int i = 0; i < 10; i++) {
            generator.generator();
        }

    }

}
