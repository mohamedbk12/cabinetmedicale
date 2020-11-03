package com.cabinet.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Consultation;
import com.cabinet.demo.entity.Rdv;
import com.cabinet.demo.repository.ConsultationRepository;
import com.cabinet.demo.repository.RdvRepository;

@Service
public class ConsultationService {
	@Autowired
    private  ConsultationRepository consultationRepository;
    
	
	 public List<Consultation> getAllConsultations(Integer idMedecin) {
	    	
	    	return consultationRepository.findByMedecinIdMedecin(idMedecin);
	    	
	    }
	 public void updatecons (Integer idCons, Consultation consultation) {
		 String notecons = null;
		 Consultation inBase=consultationRepository.findByIdConsOrNotecons(idCons, notecons);
		 consultation.setMedecin(inBase.getMedecin());
		 consultation.setRdv(inBase.getRdv());
		 consultation.setIdCons(idCons);
		 consultationRepository.save(consultation)	 ;
	 }
	 public Consultation findByIdRdv(Integer idRdv) {
			return consultationRepository.findByRdvIdRdv(idRdv);
			   
		   }
	 
	 public void addConsultation(Consultation consultation) {
	      consultationRepository.save(consultation);
	   }
	 public List<Consultation> getConsultation(Integer idCons) {
	    	
	    	return consultationRepository.findByIdCons(idCons);
	    	
	    }
	 public List<Consultation> getConsultationbyrdv(Integer idRdv, Integer idCons) {
	    	
	    	return consultationRepository.findByRdvIdRdvOrIdCons(idRdv, idCons);
	    	
	    }
	 public void delete(Integer idCons){
		 consultationRepository.deleteById(idCons);
		 }
}
