package com.azmol.section03;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lecture03IterableOrArray {
    private static final Logger log = LoggerFactory.getLogger(Lecture03IterableOrArray.class);

    public static void main(String[] args) {

        var numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Flux.fromIterable(numberList)
            .subscribe(Util.subscribe("sub number list"));

        var numberArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Flux.fromArray(numberArray)
            .subscribe(Util.subscribe("sub number array"));

    }
}
