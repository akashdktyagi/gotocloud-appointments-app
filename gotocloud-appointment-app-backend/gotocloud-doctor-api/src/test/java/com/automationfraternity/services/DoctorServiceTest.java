package com.automationfraternity.services;

import com.automationfraternity.model.Doctor;
import com.automationfraternity.repository.IDoctorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;

class DoctorServiceTest {

    DoctorService doctorService;
    IDoctorRepository doctorRepository;

    Doctor doctor = Doctor.builder()
            .withName("Akash").withCanDoHomeVisit(true).withEmailID("akash.tyagi@wow.com")
            .withClinicNameAndAddress("patal lok").withExperienceInYears(90).withRegistrationID("1234567")
            .withSpecialization("MBBS").build();
    Doctor doctorToBeUpdated = Doctor.builder()
            .withName("AkashUpdated").withCanDoHomeVisit(true).withEmailID("akash.tyagi@wow.com")
            .withClinicNameAndAddress("patal lok").withExperienceInYears(90).withRegistrationID("1234567")
            .withSpecialization("MBBS").build();

    @BeforeEach
    void init() {
        doctorRepository  = Mockito.mock(IDoctorRepository.class);
        Mockito.when(doctorRepository.save(any(Doctor.class))).then(returnsFirstArg());
        doctorService = new DoctorService(doctorRepository);
    }

    @Test
    void createDoctor() {
        Doctor doctorReturned = doctorService.createDoctor(doctor);
        Assertions.assertThat(doctorReturned).isNotNull().isEqualTo(doctor);
    }


    @Test
    void updateDoctor() throws Exception {
        Mockito.when(doctorRepository.findByRegistrationID(any())).thenReturn(doctorToBeUpdated);
        Doctor doctorReturned = doctorService.updateDoctor(doctorToBeUpdated);
        Assertions.assertThat(doctorReturned.getName()).isEqualTo(doctorToBeUpdated.getName());
    }

    @Test
    void deleteDoctor() {
    }

    @Test
    void getAllDoctors() {
    }

    @Test
    void getDoctorByID() {
    }

    @Test
    void getDoctorListByName() {
    }

    @Test
    void getDoctorListByRegistrationID() {
    }
}