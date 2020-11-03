package com.cabinet.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public List<Patient>findByFnamepatAndLnamepat(String fnamepat, String lnamepat);
	public ArrayList<Patient>findByMedecinIdMedecin(Integer idMedecin);
	   public Patient findByMailpatAndMotdepassepat(String mailpat, String motdepassepat);

	   public ArrayList<Patient> findByMedecinMailMed(String mailMed);
	   public Patient findIdMedByMailpat(String mailpat);
	   public Patient findFnameMedByMailpat(String mailpat);
	   public Patient findLnameMedByMailpat(String mailpat);
	   
	   public Patient findByIdPatient(Integer idPatient);

public Patient findIdMedecinByIdPatient(Integer idPatient);
	   
	   
public ArrayList<Patient> findByMedecinIdMedecinAndIdPatient(Integer idMedecin, Integer idPatient);
public ArrayList<Patient> findByMedecinIdMedecinOrIdPatient(Integer idMedecin, Integer idPatient);
public Patient findByCinpat(Integer cinpat);
public Patient findByMailpat(String mailpat);
public Patient findByNumtelpat(Integer numtelpat);
public ArrayList<Patient> findByMedecinIdMedecinAndLnamepat(Integer idMedecin, String lnamepat);
public ArrayList<Patient> findByMedecinIdMedecinAndCinpat(Integer idMedecin, Integer cinpat);

}