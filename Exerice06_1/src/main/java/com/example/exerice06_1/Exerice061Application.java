package com.example.exerice06_1;

import com.example.exerice06_1.domain.*;
import com.example.exerice06_1.utils.HibernateUtils;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Exerice061Application {

    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
            Appointment.class,
            Doctor.class,
            Patient.class,
            Payment.class));

    public static void main(String[] args) {
        SpringApplication.run(Exerice061Application.class, args);
    }

}
