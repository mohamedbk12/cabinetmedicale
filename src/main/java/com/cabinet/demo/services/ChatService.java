package com.cabinet.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.demo.entity.Chat;
import com.cabinet.demo.repository.ChatRepository;

@Service
public class ChatService {
	@Autowired
	private ChatRepository chatRepository ;
	public List<Chat> getall (Integer idSec, Integer idMedecin){
		return chatRepository.findBySecretaireIdSecAndMedecinIdMedecinOrderByIdchat(idSec, idMedecin);
		
	}
	public void add (Chat chat) {
		chatRepository.save(chat);	
		}
}
