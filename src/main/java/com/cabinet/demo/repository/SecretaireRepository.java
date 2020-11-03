package com.cabinet.demo.repository;


import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Secretaire;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bk
 */
public interface SecretaireRepository extends JpaRepository<Secretaire, Integer>{
	   public Secretaire findByMailSecAndMotdepassSecc(String mailSec, String motdepassSecc);
	   public ArrayList<Secretaire> findByMedecinIdMedecin(Integer idMedecin);
	   public Secretaire findIdSecByMailSec(String mailSec);
	   public Secretaire findFnameSecByMailSec(String mailSec);
	   public Secretaire findLnameSecByMailSec(String mailSec);
public Secretaire findMedecinIdMedecinByMailSec(String mailSec);
public Secretaire findMailSecByIdSec(Integer idSec);
public Secretaire findMotdepassSeccByIdSec(Integer idSec);


public Secretaire findByMailSec(String mailSec);
public Secretaire findByNumSec(Integer numSec);
 
public Secretaire findByMedecinIdMedecinOrIdSec(Integer idMedecin, Integer idSec);
}
