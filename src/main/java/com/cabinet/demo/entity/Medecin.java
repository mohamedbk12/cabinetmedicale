/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabinet.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author bk
 */

@Entity
@Table(name="Medecin")
public class Medecin{
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedecin;

    private String fnameMed;

    private String lnameMed;

    private String mailMed;

    private Integer numMed;

    private String adressMed;
    
   private String sexeMed;

    private String motdepassMed;
    
    private String specilMed;
    
    private String adresscabinet;
    
    private Float sold; 
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy="medecin", orphanRemoval = true)
    private List<Patient> patients;
    
    
 

   @OneToMany(cascade = CascadeType.ALL,mappedBy="medecin", orphanRemoval = true)
   private List<Rdv> rdvs;
   
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL, mappedBy = "medecin")
    private Secretaire secretaire;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="medecin", orphanRemoval = true)
    private List<Consultation> consultations;
    
    
    
   

  public Medecin(){
      
  }

    public Medecin(Integer idMedecin, String fnameMed, String lnameMed, String mailMed, Integer numMed, String adressMed, String sexeMed, String motdepassMed, String specilMed, String adresscabinet, Float sold) {
        this.idMedecin = idMedecin;
        this.fnameMed = fnameMed;
        this.lnameMed = lnameMed;
        this.mailMed = mailMed;
        this.numMed = numMed;
        this.adressMed = adressMed;
        this.sexeMed = sexeMed;
        this.motdepassMed = motdepassMed;
        this.specilMed = specilMed;
        this.adresscabinet = adresscabinet;
        this.sold = sold;

       }

   

    public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Secretaire getSecretaire() {
        return secretaire;
    }

    public void setSecretaire(Secretaire secretaire) {
        this.secretaire = secretaire;
    }



     public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}


    

	public List<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	

	public Integer getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Integer idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getFnameMed() {
		return fnameMed;
	}

	public void setFnameMed(String fnameMed) {
		this.fnameMed = fnameMed;
	}

	public String getLnameMed() {
		return lnameMed;
	}

	public void setLnameMed(String lnameMed) {
		this.lnameMed = lnameMed;
	}

	public String getMailMed() {
		return mailMed;
	}

	public void setMailMed(String mailMed) {
		this.mailMed = mailMed;
	}

	public Integer getNumMed() {
		return numMed;
	}

	public void setNumMed(Integer numMed) {
		this.numMed = numMed;
	}

	public String getAdressMed() {
		return adressMed;
	}

	public void setAdressMed(String adressMed) {
		this.adressMed = adressMed;
	}

	public String getSexeMed() {
		return sexeMed;
	}

	public void setSexeMed(String sexeMed) {
		this.sexeMed = sexeMed;
	}

	public String getMotdepassMed() {
		return motdepassMed;
	}

	public void setMotdepassMed(String motdepassMed) {
		this.motdepassMed = motdepassMed;
	}

	public String getSpecilMed() {
		return specilMed;
	}

	public void setSpecilMed(String specilMed) {
		this.specilMed = specilMed;
	}

	public String getAdresscabinet() {
		return adresscabinet;
	}

	public void setAdresscabinet(String adresscabinet) {
		this.adresscabinet = adresscabinet;
	}

	public Float getSold() {
		return sold;
	}

	public void setSold(Float sold) {
		this.sold = sold;
	}

	@Override
	public String toString() {
		return "Medecin [idMedecin=" + idMedecin + ", fnameMed=" + fnameMed + ", lnameMed=" + lnameMed + ", mailMed="
				+ mailMed + ", numMed=" + numMed + ", adressMed=" + adressMed + ", sexeMed=" + sexeMed
				+ ", motdepassMed=" + motdepassMed + ", specilMed=" + specilMed + ", adresscabinet=" + adresscabinet
				+ ", sold=" + sold + "]";
	}



    
    
}