package com.azmol.section02;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lecture04MonoEmptyError {

    public static final Logger log = LoggerFactory.getLogger(Lecture04MonoEmptyError.class);

    public static void main(String[] args) {

        getUserName(1).subscribe(Util.subscribe());

    }

    public static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("Jack");
            case 2 -> Mono.empty();
            default -> Mono.error(new IllegalAccessException("User not found"));
        };
    }

}
