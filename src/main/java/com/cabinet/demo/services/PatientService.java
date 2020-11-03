/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabinet.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Secretaire;
import com.cabinet.demo.repository.PatientRepository;

/**
 *
 * @author bk
 */
@Service

public class PatientService {
    @Autowired
    private  PatientRepository patientRepository;
    

    public Patient findByMailpatAndMotdepassepat(String mailpat, String motdepassepat) {
		return patientRepository.findByMailpatAndMotdepassepat(mailpat, motdepassepat);
		   
	   }
    public ArrayList<Patient> findByMailMed(String mailMed) {
 			return patientRepository.findByMedecinMailMed(mailMed);
 			   
 		   }

  
    public List<Patient> getAllPatientsbymed(Integer idMedecin) {

  	  return patientRepository.findByMedecinIdMedecin(idMedecin) ;
  	 
  	 }
    public List<Patient> getAllPatients(Integer idMedecin) {
    	
    	return patientRepository.findByMedecinIdMedecin(idMedecin);
    	
    }
    public void addPatient(Patient patient) {
    	patientRepository.save(patient);
     }
  public List<Patient> getPatientbymedandapt (Integer idMedecin, Integer idPatient){
	 return patientRepository.findByMedecinIdMedecinAndIdPatient(idMedecin, idPatient);
  }
  
  public void delete(Integer idPatient){
	  patientRepository.deleteById(idPatient);
	 }
  public void updatePatient(Integer idPatient, Patient patient){
	  Patient inBase=patientRepository.findByIdPatient(idPatient);
	  patient.setRdvs(inBase.getRdvs());
	  patient.setMedecin(inBase.getMedecin());
	  patient.setIdPatient(idPatient);
      patientRepository.save(patient);
  } 
 
  public List<Patient> getPatientbyid (Integer idMedecin, Integer idPatient){
		 return patientRepository.findByMedecinIdMedecinOrIdPatient(idMedecin, idPatient);
	  }
  public List<Patient> getrcherche (Integer idMedecin, String lnamepat){
		 return patientRepository.findByMedecinIdMedecinAndLnamepat(idMedecin, lnamepat);
	  }
  public List<Patient> getrcherchecin (Integer idMedecin, Integer cinpat){
		 return patientRepository.findByMedecinIdMedecinAndCinpat(idMedecin, cinpat);
	  }
  public Patient findbycin (Integer cinpat) {
	  return patientRepository.findByCinpat(cinpat);
  }
  public Patient findbymail (String mailpat) {
	  return patientRepository.findByMailpat(mailpat);
  }
  public Patient findbynum (Integer numtelpat) {
	  return patientRepository.findByNumtelpat(numtelpat);
  }
	  	    
}
