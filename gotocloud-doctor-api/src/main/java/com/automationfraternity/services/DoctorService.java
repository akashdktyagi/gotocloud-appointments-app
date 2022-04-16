package com.automationfraternity.services;

import com.automationfraternity.model.Doctor;
import com.automationfraternity.repository.IDoctorRepository;
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
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) throws Exception {
        Optional<Doctor> doctorIfPresent = Optional.ofNullable(doctorRepository.findByRegistrationID(doctor.getRegistrationID()));
        if (doctorIfPresent.isPresent()){
            return doctorRepository.save(doctor);
        }else{
            throw new Exception("Doctor not present with this registration id: " + doctor.getRegistrationID() + "  can not Update.");
        }
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
