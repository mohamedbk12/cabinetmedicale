package com.cabinet.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Message;
import com.cabinet.demo.entity.Rdv;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	public ArrayList<Message>findByPatientIdPatient(Integer idPatient);
	public ArrayList<Message>findBySecretaireIdSecOrderByVu(Integer idSec);
	public ArrayList<Message>findByIdmsg(Integer idmsg);
	
	public Message findByIdmsgOrObj(Integer idmsg, String obj);
public Integer countByVuAndSecretaireIdSec(String vu, Integer idSec);
}
