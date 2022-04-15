package com.automationfraternity.repository;

import com.automationfraternity.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByName(String name);
    Doctor findByRegistrationID(String registrationID);

}
