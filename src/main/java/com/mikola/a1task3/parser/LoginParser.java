package com.mikola.a1task3.parser;

import com.mikola.a1task3.entity.Login;
import com.mikola.a1task3.exception.ParseFileException;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoginParser {

    private static final String DATA_SEPARATOR = ",";
    private static final int ATTRIBUTE_COUNT = 5;

    public static List<Login> parse(List<String> strings) throws ParseFileException {
        List<Login> result = new ArrayList<>();
        for (String loginsLine : strings) {
            String[] splitLoginsLine = loginsLine.split(DATA_SEPARATOR);
            if (splitLoginsLine.length == ATTRIBUTE_COUNT) {
                String application = splitLoginsLine[0].trim();
                String appAccountName = splitLoginsLine[1].trim();
                boolean isActive = Boolean.parseBoolean(splitLoginsLine[2].trim());
                String jobTitle = splitLoginsLine[3].trim();
                String department = splitLoginsLine[4].trim();
                result.add(
                        new Login(
                                UUID.randomUUID(),
                                application,
                                appAccountName,
                                isActive,
                                jobTitle,
                                department
                        )
                );
            } else if (splitLoginsLine.length != 0) {
                throw new ParseFileException("not enough attributes");
            }
        }
        return result;
    }
}
