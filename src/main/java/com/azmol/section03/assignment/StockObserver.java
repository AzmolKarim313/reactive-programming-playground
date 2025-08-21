package com.azmol.section03.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockObserver implements Subscriber<Integer> {
    private static final Logger log = LoggerFactory.getLogger(StockObserver.class);
    private Subscription subscription;
    public final double INITIAL_BALANCE = 1000;
    private double balance = INITIAL_BALANCE;
    private int quantity = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
        this.subscription = subscription;
    }

    @Override
    public void onNext(Integer price) {
        if (price <= 90 && balance >= price) {
            quantity++;
            balance -= price;
            log.info("Buying Stock price {}, quantity {} and banance {}", price, quantity, balance);
        } else if (price >= 110 && quantity > 0) {
            log.info("Selling Stock price {}, quantity {}", price, quantity);
            balance = balance + (price * quantity);
            quantity = 0;
            subscription.cancel();
            log.info("Balance {} and profit gain {}", balance,  (balance - INITIAL_BALANCE));
        }
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("error {}", throwable);
    }

    @Override
    public void onComplete() {
        log.info("Stock Observer has been Completed!");
    }
}
