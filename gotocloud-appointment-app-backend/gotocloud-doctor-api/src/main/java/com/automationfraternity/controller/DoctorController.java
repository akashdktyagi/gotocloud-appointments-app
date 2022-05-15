package com.automationfraternity.controller;

import com.automationfraternity.model.Doctor;
import com.automationfraternity.services.DoctorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping("/doctors")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.createDoctor(doctor);
    }

    @PutMapping("/doctors")
    public Doctor updateDoctor(@RequestBody Doctor doctor) throws Exception {
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Optional<Doctor> getDoctorByID(@PathVariable Long id){
        return doctorService.getDoctorByID(id);
    }

    @GetMapping("/doctors/{name}")
    public List<Doctor> getDoctorListByName(@PathVariable String name){
        return doctorService.getDoctorListByName(name);
    }

    @GetMapping("/doctors/{registrationID}")
    public Doctor getDoctorListByRegistrationID(@PathVariable String registrationID){
        return doctorService.getDoctorListByRegistrationID(registrationID);
    }

}
