package com.hospital.service;

import com.hospital.dao.PharmacyRepository;
import com.hospital.entities.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    public List<Pharmacy> getAllMedicine()
    {
        List<Pharmacy> lst = (List<Pharmacy>) this.pharmacyRepository.findAll();
        return lst;
    }

//    public Pharmacy getMedicineById(int id)
//    {
//        Pharmacy pharmacy = null;
//        try{
//            pharmacy = this.pharmacyRepository.findById(id).get();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return pharmacy;
//    }

    public Pharmacy addMedicine(Pharmacy pharmacy)
    {
        Pharmacy p = this.pharmacyRepository.save(pharmacy);
        return p;
    }

    public void updateMedicine(Pharmacy pharmacy, int id)
    {
        pharmacy.setMedicineId(id);
        this.pharmacyRepository.save(pharmacy);
    }

    public void deleteMedicine(int id)
    {
        this.pharmacyRepository.deleteById(id);
    }

    public List<Pharmacy> showAllMedicines()
    {
        List<Pharmacy> pharmacies = new ArrayList<>();
        for(Pharmacy pharmacy:pharmacyRepository.findAll())
            pharmacies.add(pharmacy);

        return pharmacies;
    }

//    public Pharmacy getMedicineById(int id)
//    {
//        Pharmacy pharmacy = this.pharmacyRepository.findById(id)
//                .orElseThrow(()->new ResourceNotFoundException("Pharmacy", " Id ", id));
//
//        return pharmacy;
//    }


        public Pharmacy getMedicineById(int id)
        {
            Pharmacy pharmacy = this.pharmacyRepository.findById(id).get();
            return pharmacy;
        }
}
