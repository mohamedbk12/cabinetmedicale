/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabinet.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author bk
 */

@Entity
@Table(name="Consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCons;
    private String notecons;
 
      @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="idRdv", nullable = false)
     private Rdv rdv;
       
      @JsonBackReference
      @ManyToOne( fetch = FetchType.LAZY)
      @JoinColumn(name = "idMedecin")
      private Medecin medecin;
    
    public Consultation(){
        
    }

    public Consultation(Integer idCons, String notecons, Integer idRdv, Integer idMedecin, Integer idPatient) {
        this.idCons = idCons;
        this.notecons = notecons;
      this.rdv = new Rdv(idRdv, null, null, null, null, null, idMedecin, idPatient);
       this.medecin = new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null);

    }

  

    public Rdv getRdv() {
        return rdv;
    }

    public void setRdv(Rdv rdv) {
        this.rdv = rdv;
    }
    

    
  

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Integer getIdCons() {
		return idCons;
	}

	public void setIdCons(Integer idCons) {
		this.idCons = idCons;
	}

	public String getNotecons() {
		return notecons;
	}

	public void setNotecons(String notecons) {
		this.notecons = notecons;
	}

	

	@Override
	public String toString() {
		return "Consultation [idCons=" + idCons + ", notecons=" + notecons + ", rdv=" + rdv
				+ ", medecin=" + medecin + "]";
	}

	

	

 
  

   
    

   
    
}
