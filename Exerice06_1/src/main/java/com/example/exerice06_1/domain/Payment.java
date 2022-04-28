package com.example.exerice06_1.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Payment")
@Getter
@Setter
@ToString
public  class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String payDate;

    @Column
    private Double amount;
}
