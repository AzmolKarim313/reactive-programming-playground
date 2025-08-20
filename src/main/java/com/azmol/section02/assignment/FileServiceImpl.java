package com.azmol.section02.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServiceImpl implements FileService {
    private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
    public static final Path PATH = Paths.get("./src/main/resources/section02");

    @Override
    public Mono<String> readFile(String fileName) {
        return Mono.fromCallable(() -> Files.readString(PATH.resolve(fileName)));
    }

    @Override
    public Mono<Void> writeFile(String fileName, String content) {
        return Mono.fromRunnable(() -> write(fileName, content));
    }

    @Override
    public Mono<Void> deleteFile(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    public void write(String fileName, String content){
        try {
            Files.writeString(PATH.resolve(fileName), content);
            log.info("Created file {} & {}",fileName, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String fileName){
        try {
            Files.delete(PATH.resolve(fileName));
            log.info("deleted file {}",fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
