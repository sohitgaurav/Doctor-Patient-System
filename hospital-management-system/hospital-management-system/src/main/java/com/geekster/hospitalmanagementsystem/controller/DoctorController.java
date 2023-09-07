package com.geekster.hospitalmanagementsystem.controller;

import com.geekster.hospitalmanagementsystem.model.Doctor;
import com.geekster.hospitalmanagementsystem.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping("/hello")
    public String hello(){
        return "hello sohit";
    }
    @PostMapping("/doctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor){
     return doctorService.addDoctor(doctor);

    }
    @DeleteMapping("/doctor/{doctorID}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int doctorID){
        return doctorService.deleteDoctor(doctorID);
    }
    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }
}
