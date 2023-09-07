package com.geekster.hospitalmanagementsystem.service;

import com.geekster.hospitalmanagementsystem.model.Doctor;
import com.geekster.hospitalmanagementsystem.model.Patient;
import com.geekster.hospitalmanagementsystem.repository.PatientRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public ResponseEntity<String> addPatient(Patient patient) {
        if (valid(patient).isEmpty()){
            patientRepository.save(patient);
            return new ResponseEntity<>("patient profile created successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(valid(patient).toString(), HttpStatus.BAD_REQUEST);
        }
    }
    public JSONObject valid(Patient patient){
        JSONObject error = new JSONObject();

        String city= patient.getPatientCity().toLowerCase();
        if(!(city.equals("noida")|| city.equals("delhi") || city.equals("faridabad"))) {
            error.put(city, "we still waiting  to expand to your location ");
        }
        String symptom = patient.getSymptom().toLowerCase();
        if(!(symptom.equals("arthritis") || symptom.equals("back pain") || symptom.equals("dysmenorrhea") ||
                symptom.equals("skin infection") || symptom.equals("ear pain") || symptom.equals("skin burn") )){

            error.put(symptom,"There isn’t any doctor present at your location for your symptom");

        }
        return error;
    }

    public ResponseEntity<String> deletePatient(int patientID) {
        if(!patientRepository.findById(patientID).isPresent()){
            return new ResponseEntity<>("no patient exist with this id ",HttpStatus.NOT_FOUND);
        }
        else{
            patientRepository.deleteById(patientID);
            return new ResponseEntity<>("patient with id was deleted", HttpStatus.OK);
        }
    }

    public List<Patient> getPatient() {
        return  patientRepository.findAll();
    }
}
