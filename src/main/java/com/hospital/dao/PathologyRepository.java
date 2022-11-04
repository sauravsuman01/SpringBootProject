package com.hospital.dao;

import com.hospital.entities.Pathology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PathologyRepository extends JpaRepository<Pathology, Integer> {

}
