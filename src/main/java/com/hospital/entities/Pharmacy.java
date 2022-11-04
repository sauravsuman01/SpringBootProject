package com.hospital.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="pharmacy")
@Getter
@Setter
public class Pharmacy {

    @Id
    private int medicineId;
    private String medicineName;
    private int medicinePrice;
    private int medicineStock;
}
