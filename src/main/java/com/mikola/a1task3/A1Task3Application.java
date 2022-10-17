package com.mikola.a1task3;

import com.mikola.a1task3.entity.Logins;
import com.mikola.a1task3.exception.ParseFileException;
import com.mikola.a1task3.parser.LoginsParser;
import com.mikola.a1task3.reader.CsvReader;
import com.mikola.a1task3.repository.LoginsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class A1Task3Application {

    @Autowired
    private static LoginsRepository loginsRepository;

    public static void main(String[] args) throws ParseFileException {
        SpringApplication.run(A1Task3Application.class, args);
    }

}
