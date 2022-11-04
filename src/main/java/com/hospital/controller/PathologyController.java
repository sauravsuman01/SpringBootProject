package com.hospital.controller;

import com.hospital.entities.Pathology;
import com.hospital.service.PathologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PathologyController {

    @Autowired
    private PathologyService pathologyService;

    @GetMapping("/pathology")
    public ResponseEntity<List<Pathology>> getAllTests()
    {
        List<Pathology> pathology = pathologyService.getAllTests();
        if(pathology.size() <= 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(pathology));
    }

    @GetMapping("/pathology/{id}")
    public ResponseEntity<Pathology> getTestById(@PathVariable("id") int id)
    {
        Pathology pathology = pathologyService.getTestById(id);
        if(pathology == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(pathology));
    }

    @PostMapping("/pathology")
    public ResponseEntity<Pathology> addTest(@RequestBody Pathology pathology)
    {
        try{
            this.pathologyService.addTest(pathology);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<Pathology>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pathology/{id}")
    public ResponseEntity<Void> deteteTest(@PathVariable("id") int id)
    {
        try{
            this.pathologyService.deleteTest(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
