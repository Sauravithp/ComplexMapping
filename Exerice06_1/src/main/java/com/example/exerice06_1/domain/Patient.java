package com.example.exerice06_1.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Patient")
@Table(name = "Patient")
@Getter
@Setter
@ToString
@SecondaryTables(@SecondaryTable(name = "Address",pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "Patient_Id",referencedColumnName = "id")
}))
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(table = "Address")
    private String street;

    @Column(table = "Address")
    private String zip;

    @Column(table = "Address")
    private String city;

}
