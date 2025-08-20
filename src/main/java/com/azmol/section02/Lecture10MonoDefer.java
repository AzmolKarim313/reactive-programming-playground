package com.azmol.section02;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Lecture10MonoDefer {
    private static final Logger log = LoggerFactory.getLogger(Lecture10MonoDefer.class);

    public static void main(String[] args) {

        Mono.defer(() -> createPublisher())
                .subscribe(Util.subscribe("sub1"));
    }

    public static Mono<Integer> createPublisher(){
        log.info("createPublisher");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Util.sleep(2);
        return Mono.fromSupplier(() -> sum(numbers));
    }

    public static int sum(List<Integer> values){
        log.info("sum execution");
        Util.sleep(2);
        return values.stream().mapToInt(Integer::intValue).sum();
    }
}
