package com.mikola.a1task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posting {

    @Id
    private UUID id;

    @Column(name = "mat_doc")
    private long matDoc;

    @Column
    private long item;

    @Column(name = "doc_date")
    private Date docDate;

    @Column(name = "pstng_date")
    private Date pstngDate;

    @Column(name = "material_description")
    private String materialDescription;

    @Column
    private long quantity;

    @Column(name = "b_un")
    private String bUn;

    @Column(name = "amount_lc")
    private double amountLC;

    @Column
    private String crcy;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "is_authorized_posting")
    private boolean isAuthorizedPosting;



}
