package com.mikola.a1task3.parser;

import com.mikola.a1task3.entity.Logins;
import com.mikola.a1task3.entity.Postings;
import com.mikola.a1task3.exception.ParseFileException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostingsParser {

    private static final String DATA_SEPARATOR = ";";
    private static final int ATTRIBUTE_COUNT = 11;

    public List<Postings> parse(List<String> strings) throws ParseFileException {
        List<Postings> result = new ArrayList<>();
        for (String loginsLine : strings) {
            String[] splitLoginsLine = loginsLine.split(DATA_SEPARATOR);
            if (splitLoginsLine.length == ATTRIBUTE_COUNT) {
                result.add(
                        new Postings(
                                UUID.randomUUID(),
                                Long.parseLong(splitLoginsLine[0]),
                                Long.parseLong(splitLoginsLine[1]),
                                Date.valueOf(splitLoginsLine[2]),
                                Date.valueOf(splitLoginsLine[3]),
                                splitLoginsLine[4].trim(),
                                Long.parseLong(splitLoginsLine[5]),
                                splitLoginsLine[6].trim(),
                                Double.parseDouble(splitLoginsLine[7]),
                                splitLoginsLine[8].trim(),
                                splitLoginsLine[9].trim(),
                                Boolean.parseBoolean(splitLoginsLine[10])
                        )
                );
            } else {
                throw new ParseFileException("not enough attributes");
            }
        }
        return result;
    }

}
