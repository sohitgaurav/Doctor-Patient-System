package com.geekster.hospitalmanagementsystem.controller;

import com.geekster.hospitalmanagementsystem.model.Doctor;
import com.geekster.hospitalmanagementsystem.model.Patient;
import com.geekster.hospitalmanagementsystem.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/patient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient){
        return patientService.addPatient(patient);

    }
    @DeleteMapping("/patient/{patientID}")
    public ResponseEntity<String> deletePatient(@PathVariable int patientID){
        return patientService.deletePatient(patientID);
    }
    @GetMapping("/patients")
    public List<Patient> getPatient(){
        return patientService.getPatient();
    }
}
