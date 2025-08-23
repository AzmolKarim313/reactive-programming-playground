package com.azmol.sectpr05;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

/**
 *
 * Assignment :
 * Subscriber consume data of country name
 * from producer util name canada name return.
 *
 */
public class Lecture02HandleAssignment {

    private static final Logger log = LoggerFactory.getLogger(Lecture02HandleAssignment.class);

    public static void main(String[] args) {

        Flux.<String>generate((sink)->{
            sink.next(Util.faker().country().name());
        })
                .handle((item, sink)->{
                    sink.next(item);
                    if (item.equalsIgnoreCase("canada")){
                        sink.complete();
                    }
                })
                .cast(String.class)
                .subscribe(Util.subscribe());

    }
}
