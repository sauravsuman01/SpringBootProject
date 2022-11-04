package com.hospital.service;

import com.hospital.DTO.PatientDTO;
import com.hospital.dao.DoctorRepository;
import com.hospital.dao.PatientRepository;
import com.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public List<Patient> getAllPatients()
    {
        List<Patient> lst = (List<Patient>)this.patientRepository.findAll();
        return lst;
    }

    public Patient getPatientById(int id)
    {
        Patient patient = null;
        try{
            patient = this.patientRepository.findById(id).get();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return patient;
    }

    public Patient addPatient(PatientDTO patientDTO)
    {
        Patient p= new Patient();
        p.setAge(patientDTO.getAge());
        p.setFirst_name(patientDTO.getFirst_name());
        p.setLast_name(patientDTO.getLast_name());
        p.setAge(patientDTO.getAge());
        p.setAppointment_date(patientDTO.getAppointment_date());
        p.setProblem(patientDTO.getProblem());
        p.setFees(patientDTO.getFees());
        p.setDoctor(doctorRepository.findById(patientDTO.getDoctor_id()).get());
        return patientRepository.save(p);

    }

    public void deletePatient(int id)
    {
        patientRepository.deleteById(id);
    }

    public void updatePatient(Patient patient, int id)
    {
        patient.setPatient_id(id);
        patientRepository.save(patient);
    }

    public List<Patient> showAllPatients()
    {
        List<Patient> patients = new ArrayList<>();
        for(Patient patient:patientRepository.findAll())
            patients.add(patient);

        return patients;
    }

    public Patient updateAddedPatient(int id)
    {
        return patientRepository.findById(id).get();
    }


}
