package com.hospital.controller;

import com.hospital.entities.Doctor;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors()
    {
        List<Doctor> doctors = doctorService.getAllDoctors();
        if(doctors.size() <= 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(doctors));
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") int id)
    {
        Doctor doctor = doctorService.getDoctorById(id);
        if(doctor == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(doctor));
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor)
    {
        Doctor d = null;
        try{
            d = this.doctorService.addDoctor(doctor);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<Doctor>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<Void> deteteDoctor(@PathVariable("id") int id)
    {
        try{
            this.doctorService.deleteDoctor(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable("id") int id)
    {
        try
        {
            this.doctorService.updateDoctot(doctor, id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
