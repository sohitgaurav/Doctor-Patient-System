package com.geekster.hospitalmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patient_table")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    @Column(name = "patient_name")
    @Length(min = 3, message = "please enter complete name")
    private String patientName;
    @Column(name = "patient_city")
    @Length(max = 30, message = "please enter only city name")
    private String patientCity;

    @Column(name = "patient_email")
    @Email(message = "please enter valid email")
    private String patientEmail;

    @Column(name = "patient_phone_number")
    @Length(min = 10, message = "please enter valid phone number")
    private String patientPhoneNumber;
    @Column(name = "symptom")

    private String symptom;
}
