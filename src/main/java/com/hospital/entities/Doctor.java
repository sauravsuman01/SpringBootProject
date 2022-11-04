package com.hospital.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="doctor")
@Getter @Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctor_id;
    private String first_name;
    private String last_name;
    private String degree;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patientList;

}
