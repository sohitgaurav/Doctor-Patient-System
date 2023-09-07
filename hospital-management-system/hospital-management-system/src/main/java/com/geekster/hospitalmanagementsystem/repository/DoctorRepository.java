package com.geekster.hospitalmanagementsystem.repository;

import com.geekster.hospitalmanagementsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>  {

}
