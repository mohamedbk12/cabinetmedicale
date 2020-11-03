/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabinet.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Patient;

/**
 *
 * @author bk
 */
public interface MedecinRepository extends JpaRepository<Medecin, Integer> {
   public Medecin findByMailMedAndMotdepassMed(String mailMed, String motdepassMed);
   public ArrayList<Medecin> findByspecilMed(String specilMed);
   public Medecin findByIdMedecin(Integer idMedecin);
   public Medecin findIdMedByMailMed(String mailMed);
 public Medecin findByMailMed(String mailMed);
 public Medecin findByNumMed(Integer numMed);
 public ArrayList<Medecin> findByIdMedecinOrSpecilMed(Integer idMedecin,String specilMed);

}
