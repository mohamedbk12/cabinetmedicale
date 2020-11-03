package com.cabinet.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Rdv;
import com.cabinet.demo.entity.Secretaire;
import com.cabinet.demo.repository.SecretaireRepository;



@Service
public class SecretaireService {
	
	@Autowired
	private  SecretaireRepository secretaireRepository;
	    

	    public Secretaire findByMailSecAndMotdepassSecc(String mailSec, String motdepassSecc) {
			return secretaireRepository.findByMailSecAndMotdepassSecc(mailSec, motdepassSecc);
			   
		   }
	    public void addSecretaire(Secretaire secretaire) {
	        secretaireRepository.save(secretaire);
	     }
 public ArrayList<Secretaire> getSec(Integer idMedecin) {
	    	
	    	return secretaireRepository.findByMedecinIdMedecin(idMedecin);
	    	
	    }
 public List<Secretaire> getAllSecretaires(Integer idMedecin) {
 	
 	return secretaireRepository.findByMedecinIdMedecin(idMedecin);
 	
 }
 public void delete(Integer idSec){
	 secretaireRepository.deleteById(idSec);
	 }
 public Secretaire findbymail(String mailSec) {
	 return secretaireRepository.findByMailSec(mailSec);
 }
 public Secretaire findbnumSec(Integer numSec) {
	 return secretaireRepository.findByNumSec(numSec);
	}
 }
