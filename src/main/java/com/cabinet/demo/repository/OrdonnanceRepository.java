package com.cabinet.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Certificat;
import com.cabinet.demo.entity.Ordonnance;

public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Integer> {

	
	public Ordonnance findByConsultationIdCons(Integer IdCons);
	public ArrayList<Ordonnance>findByIdoOrConsultationIdCons(Integer ido, Integer IdCons);

}
