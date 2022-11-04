package com.hospital.service;

import com.hospital.dao.PathologyRepository;
import com.hospital.dao.PatientRepository;
import com.hospital.entities.Pathology;
import com.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PathologyService {

    @Autowired
    private PathologyRepository pathologyRepository;
   @Autowired
    private PatientRepository patientRepository;

    public List<Pathology> getAllTests()
    {
        List<Pathology> pathologies = (List<Pathology>) this.pathologyRepository.findAll();
        return pathologies;
    }

    public Pathology getTestById(int id)
    {
        Pathology pathology = null;
        try{
            pathology = this.pathologyRepository.findById(id).get();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return pathology;
    }

    public Pathology addTest(Pathology pathology)
    {
        Pathology p = pathologyRepository.save(pathology);
        return p;
    }

    public void deleteTest(int id)
    {
        pathologyRepository.deleteById(id);
    }



}
