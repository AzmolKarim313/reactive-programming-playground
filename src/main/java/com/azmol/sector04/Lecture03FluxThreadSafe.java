package com.azmol.sector04;

import com.azmol.common.Util;
import com.azmol.sector04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class Lecture03FluxThreadSafe {
    private static final Logger log = LoggerFactory.getLogger(Lecture03FluxThreadSafe.class);

    public static void main(String[] args) {
//        threadUnsafe();
        threadSafe();
    }

    public static void threadUnsafe(){
        var list = new ArrayList<Integer>();
        Runnable r = () ->{
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(r);
        }

        Util.sleep(5);
        log.info("Size of list: {}", list.size());
    }

    public static void threadSafe(){
        var list = new ArrayList<String>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(list::add);

        Runnable r = () ->{
            for (int i = 0; i < 1000; i++) {
                generator.generator();
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(r);
        }

        Util.sleep(5);
        log.info("Size of list: {}", list.size());
    }

}
