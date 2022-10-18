package com.mikola.a1task3.parser;

import com.mikola.a1task3.entity.Login;
import com.mikola.a1task3.entity.Posting;
import com.mikola.a1task3.exception.ParseFileException;
import com.mikola.a1task3.service.PostingService;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PostingParser {
    private static final String DATA_SEPARATOR = ";";
    private static final int ATTRIBUTE_COUNT = 10;
    private static final NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

    public static List<Posting> parse(List<String> strings, List<Login> logins) throws ParseFileException, ParseException {
        List<Posting> result = new ArrayList<>();
        for (String loginLine : strings) {
            String[] splitLoginLine = loginLine.split(DATA_SEPARATOR);
            if (splitLoginLine.length == ATTRIBUTE_COUNT) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                long matDoc = Long.parseLong(splitLoginLine[0].trim());
                long item = Long.parseLong(splitLoginLine[1].trim());
                Date docDate = dateFormat.parse(splitLoginLine[2].trim());
                Date pstngDate = dateFormat.parse(splitLoginLine[3].trim());
                String materialDescription = splitLoginLine[4].trim();
                long quantity = Long.parseLong(splitLoginLine[5].trim());
                String bUn = splitLoginLine[6].trim();
                double amountLc = format.parse(splitLoginLine[7].trim()).doubleValue();
                String crcy = splitLoginLine[8].trim();
                String userName = splitLoginLine[9].trim();
                boolean isAuthorizedPosting = logins
                        .stream()
                        .anyMatch(login -> {
                            return userName.equals(login.getAppAccountName()) && login.isActive();
                        });
                result.add(
                        new Posting(
                                UUID.randomUUID(),
                                matDoc,
                                item,
                                docDate,
                                pstngDate,
                                materialDescription,
                                quantity,
                                bUn,
                                amountLc,
                                crcy,
                                userName,
                                isAuthorizedPosting
                        )
                );
            } else if (!loginLine.isBlank()) {
                throw new ParseFileException("not enough attributes");
            }
        }
        return result;
    }

}
