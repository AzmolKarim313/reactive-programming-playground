package com.azmol.section02;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lecture07MonoRunnable {

    private static final Logger log =  LoggerFactory.getLogger(Lecture05MonoFromSupplier.class);

    public static void main(String[] args) {
        getProductName(4).subscribe(Util.subscribe());
    }

    public static Mono<String> getProductName(int productId){
        return switch (productId){
            case 1 -> Mono.just(Util.faker().commerce().productName());
            default -> Mono.fromRunnable(() -> notifingBusiness(productId));
        };
    }

    public static void notifingBusiness(int productId){
        log.info("Notifing business product {} is unavailable", productId);
    }

}
