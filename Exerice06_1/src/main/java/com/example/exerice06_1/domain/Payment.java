package com.example.exerice06_1.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@ToString
public  class Payment {

    @Column
    private String payDate;

    @Column
    private Double amount;
}
