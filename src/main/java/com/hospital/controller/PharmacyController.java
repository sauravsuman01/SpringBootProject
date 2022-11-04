package com.hospital.controller;

import com.hospital.dao.PharmacyRepository;
import com.hospital.entities.Pharmacy;
import com.hospital.exception.PharmacyServiceException;
import com.hospital.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @GetMapping("/medicines")
    public ResponseEntity<List<Pharmacy>> getAllMedicine()
    {
        List<Pharmacy> pharmacies = this.pharmacyService.getAllMedicine();
        if(pharmacies.size() <= 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(pharmacies));
    }



    @GetMapping("/medicines/{id}")
    public ResponseEntity<Pharmacy> getMedicineById(@PathVariable("id") int id)
    {
        if(true) throw new PharmacyServiceException("No medicine with given Id");

        else {
            Pharmacy pharmacy = pharmacyService.getMedicineById(id);
            if (pharmacy == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(pharmacy));
        }
    }

    @PostMapping("/medicines")
    public ResponseEntity<Pharmacy> addMedicineByID(@RequestBody Pharmacy pharmacy)
    {
        try{
            this.pharmacyService.addMedicine(pharmacy);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<Pharmacy>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable("id") int id)
    {
        try{
            this.pharmacyService.deleteMedicine(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/medicines/{id}")
    public ResponseEntity<Pharmacy> updateMedicine(@RequestBody Pharmacy pharmacy, @PathVariable("id") int id)
    {
        try
        {
            this.pharmacyService.updateMedicine(pharmacy, id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @GetMapping("/medicines/{id}")
//    public Pharmacy getMedicineById(@PathVariable(name= "id") int id)
//    {
//        return this.pharmacyService.getMedicineById(id);
//    }

}
