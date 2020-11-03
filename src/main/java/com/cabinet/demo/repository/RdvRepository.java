package com.cabinet.demo.repository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Rdv;

public interface RdvRepository extends JpaRepository<Rdv, Integer>  {
	public ArrayList<Rdv>findByMedecinIdMedecinOrderByTimeRdv(Integer idMedecin);
	   public Rdv findByIdRdv(Integer idRdv);
	   public Rdv findByMedecinIdMedecin(Integer idMedecin);
		public ArrayList<Rdv>findByPatientIdPatient(Integer idPatient);
		public ArrayList<Rdv>findByDateRdvOrderByTimeRdv(Date dateRdv);
		public ArrayList<Rdv>findByMedecinIdMedecinOrderByDateRdv(Integer idMedecin);
public Rdv findByMedecinIdMedecinAndDateRdvAndTimeRdv(Integer idMedecin, Date dateRdv, Time timeRdv);
public ArrayList<Rdv>findByMedecinIdMedecinAndDateRdv(Integer idMedecin, Date dateRdv);
}
