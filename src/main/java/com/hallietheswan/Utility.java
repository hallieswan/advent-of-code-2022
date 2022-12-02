package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class Utility {
    public static List<String> readFileLinesFromResources(String fileName) throws URISyntaxException, IOException {
        // read file from resources
        // ...https://stackoverflow.com/a/58230499
        return Files.readAllLines(
                Paths.get(
                        Utility.class.getResource("/" +fileName).toURI()
                )
        );
    }
}
