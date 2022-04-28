package com.example.exerice06_1;

import com.example.exerice06_1.domain.Appointment;
import com.example.exerice06_1.domain.Doctor;
import com.example.exerice06_1.domain.Patient;
import com.example.exerice06_1.domain.Payment;
import com.example.exerice06_1.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Exercice061Application {

    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
            Appointment.class,
            Doctor.class,
            Patient.class,
            Payment.class));

    public static void main(String[] args) {
        persistData();
        print();
    }

    public static void persistData() {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            /*
            Save Doctor
             */
            Doctor doctor=new Doctor();
            doctor.setDoctorType("Eye Doctor");
            doctor.setFirstName("Frank");
            doctor.setLastName("Brown");
            session.save(doctor);

            /*
            Save Patient
             */
            Patient patient=new Patient();
            patient.setName("John Doe");
            patient.setStreet("100 Main Street");
            patient.setCity("Boston");
            patient.setZip("23114");
            session.save(patient);

            /*
            Appointment
             */
            Payment payment=new Payment();
            payment.setAmount(100D);
            payment.setPayDate("12/06/08");

            Appointment appointment=new Appointment();
            appointment.setAppDate("15/05/08");
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setPayment(payment);

            session.save(appointment);
            tx.commit();;
        } catch (HibernateException ex) {
            tx.rollback();
        } finally {
            session.close();
            System.out.println("complete insert, session closed!!!!!");
        }

    }

    public static void print() {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Appointment appointment=session.get(Appointment.class,1L);
            System.out.println("*************Appointment*************");
            System.out.println(appointment.toString());

            Patient patient=session.get(Patient.class,1L);
            System.out.println("*************Patient*************");
            System.out.println(patient.toString());

            Doctor doctor=session.get(Doctor.class,1L);
            System.out.println("*************Patient*************");
            System.out.println(doctor.toString());

        } catch (HibernateException ex) {
            tx.rollback();
        } finally {
            session.close();
            System.out.println("complete print, session closed!!!!!");
        }
    }

}
