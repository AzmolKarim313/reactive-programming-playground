package com.azmol.sector04.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderServiceImpl implements FileReaderService {

    private static final Logger log = LoggerFactory.getLogger(FileReaderServiceImpl.class);

    @Override
    public Flux<String> readFile(Path path) {
        return Flux.generate(
                () -> openFile(path),
                (file, sink) ->{
                    return readFile((BufferedReader) file, (SynchronousSink<String>) sink);
                },
                this::closeFile
        );
    }

    public BufferedReader openFile(Path path) {
        log.info("Opening file {}", path);
        try {
            return Files.newBufferedReader(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedReader readFile(BufferedReader reader, SynchronousSink <String> sink) {
        try {
            var line = reader.readLine();
            if (line == null) {
                sink.complete();
            } else{
                sink.next(line);
            }
            return  reader;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeFile(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {}
    }

}
