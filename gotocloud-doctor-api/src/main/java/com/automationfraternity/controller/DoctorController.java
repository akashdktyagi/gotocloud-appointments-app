package com.automationfraternity.controller;

import com.automationfraternity.model.Doctor;
import com.automationfraternity.services.DoctorService;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping("/doctors")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return null;
    }

    @PutMapping("/doctors")
    public Doctor updateDoctor(){
        return null;
    }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable Integer id){

    }

    @GetMapping("/doctors")
    public void getAllDoctors(){

    }

    @GetMapping("/doctors/{id}")
    public void getDoctorByID(@PathVariable Integer id){

    }

    @GetMapping("/doctors/{name}")
    public void getDoctorListByName(@PathVariable String name){

    }
}
