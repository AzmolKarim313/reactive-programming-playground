package com.azmol.section03;

import com.azmol.common.Util;
import com.azmol.section02.client.ExternalServiceClient;
import com.azmol.section03.assignment.StockObserver;

public class LectureAssignment {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        var subscriber = new StockObserver();

        client.getPriceChanges()
                .subscribe(Util.subscribe());

        Util.sleep(20);

    }

}
