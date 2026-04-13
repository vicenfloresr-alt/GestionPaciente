package com.hospital.hospitalmedicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalmedicos.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long>{

}
