package com.azmol.section02;

import com.azmol.common.Util;
import com.azmol.section02.assignment.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LectureAssignment {
    private static final Logger log = LoggerFactory.getLogger(LectureAssignment.class);

    public static void main(String[] args) {
        var fileService = new FileServiceImpl();

        fileService.writeFile("test.txt","test").subscribe(Util.subscribe());

        fileService.readFile("test.txt").subscribe(Util.subscribe());

        fileService.deleteFile("test.txt").subscribe(Util.subscribe());

    }
}
