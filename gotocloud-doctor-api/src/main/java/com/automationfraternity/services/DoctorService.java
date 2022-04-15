package com.automationfraternity.services;

import com.automationfraternity.model.Doctor;
import com.automationfraternity.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private IDoctorRepository doctorRepository;

    public DoctorService(IDoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return null;
    }

    public void updateDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorByID(Long id){
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorListByName(String name){
        return doctorRepository.findByName(name);
    }

    public Doctor getDoctorListByRegistrationID(String id){
        return doctorRepository.findByRegistrationID(id);
    }
}
