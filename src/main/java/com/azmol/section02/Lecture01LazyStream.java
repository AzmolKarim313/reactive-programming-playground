package com.azmol.section02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class Lecture01LazyStream {

    public static final Logger log = LoggerFactory.getLogger(Lecture01LazyStream.class);

    public static void main(String[] args) {

        Stream.of(1)
                .peek(i -> log.info("received: {}", i))
                .toList();

    }

}
