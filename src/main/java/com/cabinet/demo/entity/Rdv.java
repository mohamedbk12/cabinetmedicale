/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabinet.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


 
      
/**
 *
 * @author bk
 */

@Entity
@Table(name="Rdv")
  public class Rdv  {
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRdv;
    @Temporal(javax.persistence.TemporalType.DATE)
  
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date dateRdv;
   
    
    @JsonFormat(pattern = "HH:mm:ss")
 
 
    private Time timeRdv;
    
   
    
    private Float prixRdv;
    
    private Float prixdonner;
    
    private Float prixrest;
    

    
    
    
    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idMedecin")
    private Medecin medecin;
@JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idPatient")
    private Patient patient;
     @JsonIgnore
@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL, mappedBy="rdv")
private Consultation consultation;
     public Rdv() {
    
}

    public Rdv(Integer idRdv, Date dateRdv, Time timeRdv, Float prixRdv, Float prixdonner, Float prixrest, Integer idMedecin,  Integer idPatient) {
        this.idRdv = idRdv;
        this.dateRdv = dateRdv;
        this.timeRdv = timeRdv;
     
        this.prixRdv = prixRdv;
        this.prixdonner = prixdonner;
         this.prixrest = prixrest;
      this.medecin = new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null);
      this.patient = new Patient(idPatient, null, "", "", "", null, "", null, "", null, "", "", "", "", null, "",idMedecin);
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    
    public Integer getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(Integer idRdv) {
		this.idRdv = idRdv;
	}

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public Time getTimeRdv() {
		return timeRdv;
	}

	public void setTimeRdv(Time timeRdv) {
		this.timeRdv = timeRdv;
	}

	
	public Float getPrixRdv() {
		return prixRdv;
	}

	public void setPrixRdv(Float prixRdv) {
		this.prixRdv = prixRdv;
	}

	public Float getPrixdonner() {
		return prixdonner;
	}

	public void setPrixdonner(Float prixdonner) {
		this.prixdonner = prixdonner;
	}

	public Float getPrixrest() {
		return prixrest;
	}

	public void setPrixrest(Float prixrest) {
		this.prixrest = prixrest;
	}

	@Override
	public String toString() {
		return "Rdv [idRdv=" + idRdv + ", dateRdv=" + dateRdv + ", timeRdv=" + timeRdv + ", prixRdv="
				+ prixRdv + ", prixdonner=" + prixdonner + ", prixrest=" + prixrest + ", medecin=" + medecin
				+ ", patient=" + patient + ", consultation=" + consultation + "]";
	}
	
	

	



	

    
}
