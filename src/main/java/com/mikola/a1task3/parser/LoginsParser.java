package com.mikola.a1task3.parser;

import com.mikola.a1task3.entity.Logins;
import com.mikola.a1task3.exception.ParseFileException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoginsParser {

    private static final String DATA_SEPARATOR = ",";
    private static final int ATTRIBUTE_COUNT = 5;

    public static List<Logins> parse(List<String> strings) throws ParseFileException {
        List<Logins> result = new ArrayList<>();
        for (String loginsLine : strings) {
            String[] splitLoginsLine = loginsLine.split(DATA_SEPARATOR);
            if (splitLoginsLine.length == ATTRIBUTE_COUNT) {
                result.add(
                        new Logins(
                                UUID.randomUUID(),
                                splitLoginsLine[0].trim(),
                                splitLoginsLine[1].trim(),
                                Boolean.parseBoolean(splitLoginsLine[2]),
                                splitLoginsLine[3].trim(),
                                splitLoginsLine[4].trim()
                        )
                );
            } else {
                throw new ParseFileException("not enough attributes");
            }
        }
        return result;
    }
}
