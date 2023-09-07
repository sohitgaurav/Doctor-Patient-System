package com.geekster.hospitalmanagementsystem.service;

import com.geekster.hospitalmanagementsystem.model.Doctor;
import com.geekster.hospitalmanagementsystem.repository.DoctorRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public ResponseEntity<String> addDoctor(Doctor doctor) {
        if (valid(doctor).isEmpty()){
            doctorRepository.save(doctor);
       return new ResponseEntity<>("doctor profile created successfully",HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(valid(doctor).toString(), HttpStatus.BAD_REQUEST);
        }

    }


    public JSONObject valid(Doctor doctor){
        JSONObject error = new JSONObject();

        String city= doctor.getDoctorCity().toLowerCase();
        if(!(city.equals("noida")|| city.equals("delhi") || city.equals("faridabad"))) {
            error.put(city, "doctor location should be in ncr");
        }
        String speciality = doctor.getDoctorSpecialization().toLowerCase();
        if(!(speciality.equals("orthopedic") || speciality.equals("gynecology") || speciality.equals("dermatology") ||
                speciality.equals("ent"))){
            error.put(speciality,"doctor speciality should be in  orthopedic ,gynecology ,dermatology ,ent");

        }
      return error;
    }

    public ResponseEntity<String> deleteDoctor(int doctorID) {
        if(!doctorRepository.findById(doctorID).isPresent()){
            return new ResponseEntity<>("no doctor exist with this id ",HttpStatus.NOT_FOUND);
        }
        else{
            doctorRepository.deleteById(doctorID);
            return new ResponseEntity<>("doctor with id was deleted", HttpStatus.OK);
        }
    }

    public List<Doctor> getDoctors() {
        return  doctorRepository.findAll();
    }
}
