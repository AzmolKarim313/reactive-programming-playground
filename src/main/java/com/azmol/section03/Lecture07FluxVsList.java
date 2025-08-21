package com.azmol.section03;

import com.azmol.common.Util;
import com.azmol.section03.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lecture07FluxVsList {
    private static final Logger log = LoggerFactory.getLogger(Lecture07FluxVsList.class);

    public static void main(String[] args) {
        var nameList = NameGenerator.generateNamesList(10);
        log.info("nameList: {}", nameList);

        var nameFlux = NameGenerator.generateNamesFlux(10);
        nameFlux.subscribe(Util.subscribe());
    }
}
