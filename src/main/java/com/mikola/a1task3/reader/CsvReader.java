package com.mikola.a1task3.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CsvReader {

    public static List<String> read(String stringPath) {

        List<String> result = new ArrayList<>();
        Path path = Paths.get(stringPath);
        try {
            result = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.remove(0);
        return result;
    }

}
