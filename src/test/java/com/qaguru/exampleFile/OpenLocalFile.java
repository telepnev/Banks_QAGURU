package com.qaguru.exampleFile;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class OpenLocalFile {

    @Test
    void openLocalFile() throws URISyntaxException {

        String path = Paths.get(ClassLoader.getSystemResource("test.html").toURI()).toFile().getAbsolutePath();
        String path2 = new File("src/test/resources/test.html").getAbsolutePath();
        System.out.println(path);
        System.out.println(path2);
        open("file://" + path);
        sleep(10000);
        open("file://" + path2);
        sleep(10000);
    }
}
