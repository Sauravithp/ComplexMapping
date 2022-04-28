package com.example.exerice06_1.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Doctor")
@Table(name = "Doctor")
@Getter
@Setter
@ToString
public abstract class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String doctorType;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
