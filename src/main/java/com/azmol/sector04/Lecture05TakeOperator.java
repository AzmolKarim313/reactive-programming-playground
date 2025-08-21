package com.azmol.sector04;

import com.azmol.common.Util;
import reactor.core.publisher.Flux;

public class Lecture05TakeOperator {

    public static void main(String[] args) {
        takeUntilExample();
    }

    public static void takeExample(){
        Flux.range(1, 10)
                .log("range2take")
                .take(3)
                .log("take2subscriber")
                .subscribe(Util.subscribe());
    }

    public static void takeWhileExample(){
        Flux.range(1, 10)
                .log("range2take")
                .takeWhile(i -> i < 5)
                .log("take2subscriber")
                .subscribe(Util.subscribe());
    }

    public static void takeUntilExample(){
        Flux.range(1, 10)
                .log("range2take")
                .takeUntil(i -> i < 5)
                .log("take2subscriber")
                .subscribe(Util.subscribe());
    }

}
