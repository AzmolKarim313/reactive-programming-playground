package com.azmol.section03.helper;

import com.azmol.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.IntStream;

public class NameGenerator {

    public static List<String> generateNamesList(int count) {
        return IntStream
                .rangeClosed(1, count)
                .mapToObj(i -> generateName())
                .toList();
    }

    public static Flux<String> generateNamesFlux(int count) {
        return Flux.range(1, count)
                .map(i -> generateName());
    }

    public static String generateName() {
        Util.sleep(1);
        return Util.faker().name().fullName();
    }

}
