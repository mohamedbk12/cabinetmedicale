package com.cabinet.demo.services;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Rdv;
import com.cabinet.demo.repository.PatientRepository;
import com.cabinet.demo.repository.RdvRepository;

@Service
public class RdvService {
	@Autowired
    private  RdvRepository rdvRepository;
    
	
	 public List<Rdv> getAllRdvs(Integer idMedecin) {
	    	
	    	return rdvRepository.findByMedecinIdMedecinOrderByTimeRdv(idMedecin);
	    	
	    }
	 public List<Rdv> getAllRdvsda(Integer idMedecin) {
	    	
	    	return rdvRepository.findByMedecinIdMedecinOrderByDateRdv(idMedecin);
	    	
	    }
	 public Rdv findByIdRdv(Integer idRdv) {
			return rdvRepository.findByIdRdv(idRdv);
			   
		   }
	 
	 public void updaterdv(Integer idRdv, Rdv rdv){
		 Rdv inBase= rdvRepository.findByIdRdv(idRdv);
		 rdv.setPatient(inBase.getPatient());
		 rdv.setMedecin(inBase.getMedecin());
		 rdv.setConsultation(inBase.getConsultation());
		 rdv.setIdRdv(idRdv);
		 rdvRepository.save(rdv);
	   
	  } 
	 public List<Rdv> getAllRdvsPat(Integer idPatient) {
	    	
	    	return rdvRepository.findByPatientIdPatient(idPatient);
	    	
	    }
	 public List<Rdv> recherche(Integer idMedecin, Date dateRdv) {
	    	
	    	return rdvRepository.findByMedecinIdMedecinAndDateRdv(idMedecin, dateRdv);
	    	
	    }
	 public List<Rdv> getAllRdvstoday(Date dateRdv) {
	    	
	    	return rdvRepository.findByDateRdvOrderByTimeRdv(dateRdv) ;
	    	
	    }
	 public void addRdv(Rdv rdv) {
	    	rdvRepository.save(rdv);
	     }
	 public void delete(Integer idRdv){
		  rdvRepository.deleteById(idRdv);
		 }
		     
	 public Rdv getrdvbybyby (Integer idMedecin, Date dateRdv, Time timeRdv) {
		 return rdvRepository.findByMedecinIdMedecinAndDateRdvAndTimeRdv(idMedecin, dateRdv, timeRdv);
	 }
}
