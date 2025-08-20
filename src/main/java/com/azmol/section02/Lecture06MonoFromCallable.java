package com.azmol.section02;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Lecture06MonoFromCallable {

    public static final Logger logg = LoggerFactory.getLogger(Lecture06MonoFromCallable.class);

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Mono.fromCallable(() -> sum(numbers))
                .subscribe(Util.subscribe("sub1"));
    }

    public static int sum(List<Integer> values){
        logg.info("Finding the values: {}", values);
        return values.stream().mapToInt(Integer::intValue).sum();
    }

}
