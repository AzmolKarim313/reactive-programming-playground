package com.azmol.sectpr05;

import com.azmol.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

/**
 *
 * Handle behaves like filter + map
 *
 * 1 => -2
 * 4 => do not send
 * 7 => error
 * everything else => send as it is
 *
 */
public class Lecture01Handle {
    private static final Logger log = LoggerFactory.getLogger(Lecture01Handle.class);

    public static void main(String[] args) {

         Flux.range(1, 10)
                 .filter( i -> i != 7)
                 .handle((item, sink) -> {
                     switch (item){
                         case 1 -> sink.next(-2);
                         case 4 -> {}
                         case 7 -> sink.error(new RuntimeException("oops"));
                         default -> sink.next(item);
                     }
                 })
                 .cast(Integer.class)
                 .subscribe(Util.subscribe());

    }

}
