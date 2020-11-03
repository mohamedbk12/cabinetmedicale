package com.cabinet.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Consultation;
import com.cabinet.demo.entity.Rdv;


	public interface ConsultationRepository extends JpaRepository<Consultation, Integer>  {
		public ArrayList<Consultation>findByMedecinIdMedecin(Integer idMedecin);
		   public Consultation findByRdvIdRdv(Integer idRdv);
			public ArrayList<Consultation>findByIdCons(Integer idCons);
			public ArrayList<Consultation>findByRdvIdRdvOrIdCons(Integer idRdv, Integer idCons);
public Consultation findByIdConsOrNotecons(Integer idCons, String notecons);
	}

