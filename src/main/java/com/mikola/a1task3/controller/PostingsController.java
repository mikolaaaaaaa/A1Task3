package com.mikola.a1task3.controller;

import com.mikola.a1task3.entity.Period;
import com.mikola.a1task3.entity.Posting;
import com.mikola.a1task3.service.PostingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posting")
public class PostingsController {

    private PostingService service;

    public PostingsController(PostingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Posting> getByDate(@RequestParam(name = "isAuthorized", defaultValue = "false",required = false) boolean isAuthorized,
                                   @RequestParam(name = "period") Period period,
                                   @RequestParam(name = "year", required = false) String year,
                                   @RequestParam(name = "quarter", required = false) String quarter,
                                   @RequestParam(name = "month",required = false) String month,
                                   @RequestParam(name = "day",required = false) String day) {

        return service.getByDate(isAuthorized, period, year, quarter, month, day);

    }
}
