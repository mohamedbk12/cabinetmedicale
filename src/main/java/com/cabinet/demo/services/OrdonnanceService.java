package com.cabinet.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Certificat;
import com.cabinet.demo.entity.Ordonnance;
import com.cabinet.demo.repository.CertificatRepository;
import com.cabinet.demo.repository.OrdonnanceRepository;

@Service
public class OrdonnanceService {
	@Autowired
	private OrdonnanceRepository ordonnanceRepository ;
	
	public void addOrdonnance(Ordonnance ordonnance) {
		ordonnanceRepository.save(ordonnance);
	}
	 public List<Ordonnance> getord(Integer idCons, Integer ido) {
	    	
	    	return ordonnanceRepository.findByIdoOrConsultationIdCons(ido, idCons);
	    	
	    }
}


