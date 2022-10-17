package com.mikola.a1task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Postings {

    @Id
    private UUID id;

    private long matDoc;

    private long item;

    private Date docDate;

    private Date pstngDate;

    private String materialDescription;

    private long quantity;

    private String bUn;

    private double amountLC;

    private String crcy;

    private String userName;

    private boolean isAuthorizedDelivery;

}
