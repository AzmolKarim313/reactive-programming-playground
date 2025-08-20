package com.azmol.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Util {

    private static final Logger log = LoggerFactory.getLogger(Util.class);
    public static final Faker faker = Faker.instance();

    public static <T> Subscriber<T> subscribe(){
        return new DefaultSubscriber<T>("");
    }

    public static <T> Subscriber<T> subscribe(String subscriberName){
        return new DefaultSubscriber<T>(subscriberName);
    }

    public static Faker faker(){
        return faker;
    }

    public static void sleep(long sleepTime) {
        try {
            Thread.sleep(Duration.ofSeconds(sleepTime));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
