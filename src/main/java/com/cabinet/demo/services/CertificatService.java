package com.cabinet.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Certificat;
import com.cabinet.demo.entity.Consultation;
import com.cabinet.demo.repository.CertificatRepository;

@Service
public class CertificatService {
	@Autowired
	private CertificatRepository certificatRepository ;
	
	public void addCertificat(Certificat certificat) {
		certificatRepository.save(certificat);
	}
	
	 public List<Certificat> getcert(Integer idCons, Integer idCertificat) {
	    	
	    	return certificatRepository.findByIdCertificatOrConsultationIdCons(idCertificat, idCons);
	    	
	    }
}