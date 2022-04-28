package com.example.exerice06_1.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Appointment")
@Table(name = "Appointment")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String appDate;

    @OneToOne
    @JoinColumn(name = "Patient_Id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "Doctor_Id")
    private Doctor doctor;

   @Embedded
    private Payment payment;
}
