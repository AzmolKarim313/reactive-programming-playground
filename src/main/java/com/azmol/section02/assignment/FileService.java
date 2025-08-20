package com.azmol.section02.assignment;

import reactor.core.publisher.Mono;

public interface FileService {

    Mono<String> readFile(String fileName);
    Mono<Void> writeFile(String fileName, String content);
    Mono<Void> deleteFile(String fileName);

}
