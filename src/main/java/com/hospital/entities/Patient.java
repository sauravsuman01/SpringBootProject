package com.hospital.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="patient")
@Getter @Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;
    private String first_name;
    private String last_name;
    private Integer age;
    private Date appointment_date;
    private String problem;
    private String fees;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "doctor")
    private Doctor doctor;

}
