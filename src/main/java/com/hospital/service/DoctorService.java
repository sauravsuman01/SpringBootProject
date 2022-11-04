package com.hospital.service;

import com.hospital.dao.DoctorRepository;
import com.hospital.dao.PatientRepository;
import com.hospital.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Doctor> getAllDoctors()
    {
        List<Doctor> lst = (List<Doctor>)this.doctorRepository.findAll();
        return lst;
    }

    public Doctor getDoctorById(int id)
    {
        Doctor doctor = null;
        try{
            doctor = this.doctorRepository.findById(id).get();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return doctor;
    }

    public Doctor addDoctor(Doctor doctor)
    {
        Doctor d = doctorRepository.save(doctor);
        return d;
    }

    public void deleteDoctor(int id)
    {
        doctorRepository.deleteById(id);
    }

    public void updateDoctot(Doctor doctor, int id)
    {
        doctor.setDoctor_id(id);
        doctorRepository.save(doctor);
    }


}
