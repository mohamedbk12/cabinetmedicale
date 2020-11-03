package com.cabinet.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Message;
import com.cabinet.demo.entity.Messagesec;

public interface MessagesecRepository extends JpaRepository<Messagesec, Integer> {
	public ArrayList<Messagesec>findByPatientIdPatient(Integer idPatient);
	public ArrayList<Messagesec>findBySecretaireIdSec(Integer idSec);

public ArrayList<Messagesec>findByIdmsgs(Integer idmsgs);
	
	public Messagesec findByIdmsgsOrObjs(Integer idmsgs, String objs);
public Integer countByVusAndPatientIdPatient(String vus, Integer idPatient);
}
