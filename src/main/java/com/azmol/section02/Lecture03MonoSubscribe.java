package com.azmol.section02;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lecture03MonoSubscribe {

    public static final Logger log = LoggerFactory.getLogger(Lecture03MonoSubscribe.class);

    public static void main(String[] args) {
        var mono = Mono.just("Azmol");
        mono.subscribe(Util.subscribe());
        mono.subscribe(Util.subscribe("sub1"));
        mono.subscribe(Util.subscribe("sub2"));
    }

}
