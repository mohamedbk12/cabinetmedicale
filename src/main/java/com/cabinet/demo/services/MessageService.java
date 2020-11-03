package com.cabinet.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Message;
import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Rdv;
import com.cabinet.demo.repository.MessageRepository;
import com.cabinet.demo.repository.PatientRepository;

@Service
public class MessageService {
	@Autowired
	private  MessageRepository messageRepository;
	
	 public void addMsg(Message message) {
		 messageRepository.save(message);
	     }
	 public List<Message> getAllmsg(Integer idPatient) {
	    	
	    	return messageRepository.findByPatientIdPatient(idPatient);
	    	
	    }
	 public List<Message> getAllmsgsec(Integer idSec) {
	    	
	    	return messageRepository.findBySecretaireIdSecOrderByVu(idSec);
	    	
	    }
	 public List<Message> getAllmsgsecpat(Integer idmsg) {
	    	
	    	return messageRepository.findByIdmsg(idmsg);
	    	
	    }
	 public void change (Message message ,Integer idmsg, String obj) {
		Message inBase = messageRepository.findByIdmsgOrObj(idmsg, obj);
		message.setPatient(inBase.getPatient());
		message.setSecretaire(inBase.getSecretaire());
		message.setIdmsg(idmsg);
		message.setMsg(inBase.getMsg());
		message.setObj(inBase.getObj());
		message.setVu("oui");
		messageRepository.save(message);
		 
	 }
	
	 }
