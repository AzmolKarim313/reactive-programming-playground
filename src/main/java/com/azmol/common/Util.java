package com.azmol.common;

import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Util {

    private static final Logger log = LoggerFactory.getLogger(Util.class);

    public static <T> Subscriber<T> subscribe(){
        return new DefaultSubscriber<T>("");
    }

    public static <T> Subscriber<T> subscribe(String subscriberName){
        return new DefaultSubscriber<T>(subscriberName);
    }

}
