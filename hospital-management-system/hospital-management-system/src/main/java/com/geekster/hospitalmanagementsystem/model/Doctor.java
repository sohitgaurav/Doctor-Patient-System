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
@Table(name="doctor_table")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @Column(name="doctor_name")
    @Length(min=3,message = "please enter complete name")
    private String doctorName;
    @Column(name="doctor_city")
    @Length(max=30,message ="please enter only city name")
    private String doctorCity;

    @Column(name="doctor_email")
    @Email(message="please enter valid email")
    private String doctorEmail;

    @Column(name="doctor_phone_number")
    @Length(min=10,message = "please enter valid phone number")
    private String doctorPhoneNumber;
    @Column(name="doctor_specialization")

    private String doctorSpecialization;

}
