package com.mikola.a1task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    @Id
    private UUID id;

    @Column
    private String application;

    @Column(name = "app_account_name")
    private String appAccountName;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "job_title")
    private String jobTitle;

    @Column
    private String department;


}
