package com.hospital.DTO;

import com.hospital.entities.Doctor;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
public class PatientDTO {
    private String first_name;
    private String last_name;
    private Integer age;
    private Date appointment_date;
    private String problem;

    private Integer doctor_id;
    private String fees;

}
