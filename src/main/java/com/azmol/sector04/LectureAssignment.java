package com.azmol.sector04;

import com.azmol.common.Util;
import com.azmol.section01.subscriber.SubscriberImpl;
import com.azmol.sector04.assignment.FileReaderServiceImpl;

import java.nio.file.Paths;

import static com.azmol.common.Util.subscribe;

public class LectureAssignment {

    public static void main(String[] args) {
        var flux = new FileReaderServiceImpl();
        var subscribe = new SubscriberImpl();

        flux.readFile(Paths.get("./src/main/resources/section04/assignment.txt"))
                .subscribe(subscribe);

        Util.sleep(2);
        subscribe.getSubscription().request(1);
        Util.sleep(2);
        subscribe.getSubscription().cancel();
        Util.sleep(2);
        subscribe.getSubscription().request(1);

    }

}
