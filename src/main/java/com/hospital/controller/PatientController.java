package com.hospital.controller;

import com.hospital.DTO.PatientDTO;
import com.hospital.entities.Patient;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients()
    {
        List<Patient> patients = patientService.getAllPatients();
        if(patients.size() <= 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(patients));
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id)
    {
        Patient patient = patientService.getPatientById(id);
        if(patient == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(patient));
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientDTO patientDTO)
    {
        try{
            this.patientService.addPatient(patientDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<Patient>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> detetePatient(@PathVariable("id") int id)
    {
        try{
            this.patientService.deletePatient(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable("id") int id)
    {
        try
        {
            this.patientService.updatePatient(patient, id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
