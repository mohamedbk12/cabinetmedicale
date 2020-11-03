package com.cabinet.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.repository.MedecinRepository;
@Service
public class MedecinService {
	@Autowired
	private  MedecinRepository medecinRepository;
	
	
	public List<Medecin> getAllMedecins() {
	
    	return medecinRepository.findAll();
    	
    }
	 
	public void saveMedecin(Medecin medecin ) {
		medecinRepository.save(medecin);
	}
	   public Medecin findByMailMedAndMotdepassMed(String mailMed, String motdepassMed) {
		return medecinRepository.findByMailMedAndMotdepassMed(mailMed, motdepassMed);
		   
	   }
	   public Medecin findByIdMedecin(Integer idMedecin) {
			return medecinRepository.findByIdMedecin(idMedecin);
			   
		   }

	   public Integer get(Integer idMedecin) {
			return (idMedecin);
			   
		   }
	   public List<Medecin> findone (Integer idMedecin, String specilMed) {
		   return medecinRepository.findByIdMedecinOrSpecilMed(idMedecin, specilMed); 
	}
	   public List<Medecin> findall () {
	   return medecinRepository.findAll(); 
}
	   public Medecin findmail(String mailMed) {
		   return medecinRepository.findByMailMed(mailMed);
	   }
	   public Medecin findnumMed(Integer numMed) {
		   return medecinRepository.findByNumMed(numMed);
	   }
	   public void updatemedecin (Integer idMedecin, Medecin medecin) {
		Medecin inBase=medecinRepository.findByIdMedecin(idMedecin);
		medecin.setPatients(inBase.getPatients());
		medecin.setConsultations(inBase.getConsultations());
		medecin.setRdvs(inBase.getRdvs());
		medecin.setSecretaire(inBase.getSecretaire());
		medecin.setIdMedecin(idMedecin);
		medecinRepository.save(medecin);
	   }
	   
	   
	   
	   }
