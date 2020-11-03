package com.cabinet.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Certificat;
import com.cabinet.demo.entity.Rdv;

public interface CertificatRepository extends JpaRepository<Certificat, Integer> {

	public Certificat findByConsultationIdCons(Integer IdCons);
	public ArrayList<Certificat>findByIdCertificatOrConsultationIdCons(Integer idCertificat, Integer idCons);

}
