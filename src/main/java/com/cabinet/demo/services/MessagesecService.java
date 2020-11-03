package com.cabinet.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Message;
import com.cabinet.demo.entity.Messagesec;
import com.cabinet.demo.repository.MessageRepository;
import com.cabinet.demo.repository.MessagesecRepository;
@Service
public class MessagesecService {
	@Autowired
	private  MessagesecRepository messagesecRepository;
	
	 public void addMsgsec(Messagesec messagesec) {
		 messagesecRepository.save(messagesec);
	     }
	 public List<Messagesec> getAllmsgsec(Integer idPatient) {
	    	
	    	return messagesecRepository.findByPatientIdPatient(idPatient);
	    	
	    }
	 public List<Messagesec> getAllmsgsecsec(Integer idSec) {
	    	
	    	return messagesecRepository.findBySecretaireIdSec(idSec);
	    	
	    }
	 public List<Messagesec> getAllmsgsecpata(Integer idmsgs) {
	    	
	    	return messagesecRepository.findByIdmsgs(idmsgs);
	    	
	    }
	 public void change (Messagesec messagesec ,Integer idmsgs, String objs) {
		Messagesec inBase = messagesecRepository.findByIdmsgsOrObjs(idmsgs, objs);
		messagesec.setPatient(inBase.getPatient());
		messagesec.setSecretaire(inBase.getSecretaire());
		messagesec.setIdmsgs(idmsgs);
		messagesec.setMsgs(inBase.getMsgs());
		messagesec.setObjs(inBase.getObjs());
		messagesec.setVus("oui");
		messagesecRepository.save(messagesec);
		 
	 }
	
}