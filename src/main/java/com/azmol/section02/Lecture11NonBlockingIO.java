package com.azmol.section02;

import com.azmol.common.Util;
import com.azmol.section02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lecture11NonBlockingIO {
    private static final Logger log = LoggerFactory.getLogger(Lecture11NonBlockingIO.class);

    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        client.getProductName(1)
                .subscribe(Util.subscribe());

        Util.sleep(3);

    }
}
