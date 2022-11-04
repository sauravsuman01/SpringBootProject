package com.hospital.controller;

import com.hospital.DTO.PatientDTO;
import com.hospital.entities.Doctor;
import com.hospital.entities.Pathology;
import com.hospital.entities.Patient;
import com.hospital.entities.Pharmacy;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;
import com.hospital.service.PharmacyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PharmacyService pharmacyService;

    @RequestMapping("/")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/patientRegister")
    public String patientRegistration(Model model, Patient patient)
    {
        model.addAttribute(patient);
        return "patientRegisterPage";
    }

    @RequestMapping(value = "/savePatient")
    public String submitRegistration(PatientDTO patientDTO) {
        patientService.addPatient(patientDTO);
        return "home";
    }

    @RequestMapping("/adminHome")
    public String adminHome()
    {
        return "adminHomePage";
    }

    @RequestMapping("/doctorRegister")
    public String doctorRegistration(Model model, Doctor doctor)
    {
        model.addAttribute(doctor);
        return "doctorRegisterPage";
    }

    @RequestMapping(value = "/saveDoctor")
    public String submitDoctorRegistration(Doctor doctor) {
        doctorService.addDoctor(doctor);
        return "adminHomePage";
    }

    @RequestMapping("/addMedicine")
    public String addMedicine(Model model, Pharmacy pharmacy)
    {
        model.addAttribute(pharmacy);
        return "addMedicinePage";
    }

    @RequestMapping(value = "/saveMedicine")
    public String submitMedicine(Pharmacy pharmacy) {
        pharmacyService.addMedicine(pharmacy);
        return "adminHomePage";
    }

    @RequestMapping("/viewAppointment")
    public String viewAppointment(HttpServletRequest request)
    {
        request.setAttribute("patient", patientService.showAllPatients());
        return "viewAllAppointment";
    }

    @RequestMapping("/deletePatient")
    public String deletePatient(@RequestParam int id, HttpServletRequest request)
    {
        patientService.deletePatient(id);
        request.setAttribute("patient", patientService.showAllPatients());
        return "viewAllAppointment";
    }

    @RequestMapping("/updatePatient")
    public String updatePatient(Model model, Patient patient)
    {
        model.addAttribute(patient);
        return "updatePatientPage";
    }

    @RequestMapping("/updateAddedPatient")
    public String updateAddedPatient(@RequestParam int id, HttpServletRequest request)
    {
        request.setAttribute("patient", patientService.updateAddedPatient(id));
        return "viewAllAppointment";
    }

    @RequestMapping("/loginPatient")
    public String patientLogin(Model model, Patient patient)
    {
        model.addAttribute(patient);
        return "loginPatientPage";
    }

    @RequestMapping("/loggedPatient")
    public String loginPatient(@ModelAttribute Patient patient, HttpServletRequest request)
    {
        int id = patient.getPatient_id();
        if(patientService.getPatientById(id)!=null)
        {
            request.setAttribute("patient", patientService.getPatientById(id));
            return "loggedPatientPage";
        }

        else{
            request.setAttribute("error", "Invalid Patient Id");
            return "loginPatientPage";
        }
    }

    @RequestMapping("/viewPharmacy")
    public String viewPharmacy(HttpServletRequest request)
    {
        request.setAttribute("pharmacy", pharmacyService.showAllMedicines());
        return "viewAllPharmacy";
    }

    @RequestMapping("/addTest")
    public String addTest(Model model, Pathology pathology)
    {
        model.addAttribute(pathology);
        return "addTestPage";
    }
}
