package com.mikola.a1task3.service;

import com.mikola.a1task3.entity.Period;
import com.mikola.a1task3.entity.Posting;
import com.mikola.a1task3.repository.PostingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostingService {
    private PostingRepository repository;

    public PostingService(PostingRepository repository) {
        this.repository = repository;
    }

    public List<Posting> getByDate(boolean isAuthorized, Period period, String year,
                                   String quarter, String month, String day) {
        List<Posting> postings = new ArrayList<>();
        switch (period) {
            case YEAR -> {
                if (isAuthorized) {
                    postings = repository.getAuthorizedByYear(Double.parseDouble(year));
                } else {
                    postings = repository.getByYear(Double.parseDouble(year));
                }
            }
            case QUARTER -> {
                if (isAuthorized) {
                    postings = repository.getAuthorizedByQuarter(Double.parseDouble(year),
                            Integer.parseInt(quarter));
                } else {
                    postings = repository.getByQuarter(Double.parseDouble(year),
                            Integer.parseInt(quarter));
                }
            }
            case MONTH -> {
                if (isAuthorized) {
                    postings = repository.getAuthorizedByMonth(Double.parseDouble(year),
                            Double.parseDouble(month));
                } else {
                    postings = repository.getByMonth(Double.parseDouble(year),
                            Double.parseDouble(month));
                }
            }
            case DAY -> {
                if (isAuthorized) {
                    postings = repository.getAuthorizedByDay(Double.parseDouble(year),
                            Double.parseDouble(month),
                            Double.parseDouble(day));
                } else {
                    postings = repository.getByDay(Double.parseDouble(year),
                            Double.parseDouble(month),
                            Double.parseDouble(day));
                }
            }
        }
        return postings;
    }

}
