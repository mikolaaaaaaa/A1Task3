package com.mikola.a1task3;

import com.mikola.a1task3.entity.Login;
import com.mikola.a1task3.entity.Posting;
import com.mikola.a1task3.exception.ParseFileException;
import com.mikola.a1task3.parser.LoginParser;
import com.mikola.a1task3.parser.PostingParser;
import com.mikola.a1task3.reader.CsvReader;
import com.mikola.a1task3.repository.LoginRepository;
import com.mikola.a1task3.repository.PostingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class A1Task3Application {

    private static LoginRepository loginRepository;
    private static PostingRepository postingRepository;

    public A1Task3Application(LoginRepository loginRepository, PostingRepository postingRepository) {
        this.loginRepository = loginRepository;
        this.postingRepository = postingRepository;
    }

    public static void main(String[] args) throws ParseFileException, ParseException {
        SpringApplication.run(A1Task3Application.class, args);
        List<String> loginslines = CsvReader.read("src/main/resources/static/data/logins.csv");
        List<Login> logins = LoginParser.parse(loginslines);
        List<String> postingsLines = CsvReader.read("src/main/resources/static/data/postings.csv");
        List<Posting> postings = PostingParser.parse(postingsLines,logins);
        loginRepository.saveAll(logins);
        postingRepository.saveAll(postings);
    }

}
