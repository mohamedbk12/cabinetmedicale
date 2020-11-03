package com.cabinet.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Chat;
import com.cabinet.demo.entity.Message;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
	public  ArrayList<Chat>findBySecretaireIdSecAndMedecinIdMedecinOrderByIdchat(Integer idSec, Integer idMedecin);

}
