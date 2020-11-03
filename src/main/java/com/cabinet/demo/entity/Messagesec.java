package com.cabinet.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Messagesec")
public class Messagesec {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idmsgs;
     private String objs;
     private String msgs;
     private String vus;

     @JsonBackReference
     @ManyToOne( fetch = FetchType.LAZY)
     @JoinColumn(name = "idSec")
     private Secretaire secretaire;
     @JsonBackReference
     @ManyToOne( fetch = FetchType.LAZY)
     @JoinColumn(name = "idPatient")
     private Patient patient;
     
     public Messagesec() {
    	 
     }

	public Messagesec(Integer idmsgs, String objs, String msgs, String vus, Integer idPatient, Integer idSec, Integer idMedecin) {
		super();
		this.idmsgs = idmsgs;
		this.objs = objs;
		this.msgs = msgs;
		this.vus = vus;
		this.secretaire = new Secretaire(idSec, "", "", "", null, "", "", "", idMedecin);
		this.patient = new Patient(idPatient, null, "", "", "", null, "", null, "", null, "", "", "", "", null, "",idMedecin);
	}

	public Integer getIdmsgs() {
		return idmsgs;
	}

	public void setIdmsgs(Integer idmsgs) {
		this.idmsgs = idmsgs;
	}

	public String getObjs() {
		return objs;
	}

	public void setObjs(String objs) {
		this.objs = objs;
	}

	public String getMsgs() {
		return msgs;
	}

	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}

	public String getVus() {
		return vus;
	}

	public void setVus(String vus) {
		this.vus = vus;
	}

	public Secretaire getSecretaire() {
		return secretaire;
	}

	public void setSecretaire(Secretaire secretaire) {
		this.secretaire = secretaire;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Messagesec [idmsgs=" + idmsgs + ", objs=" + objs + ", msgs=" + msgs + ", vus=" + vus + ", secretaire="
				+ secretaire + ", patient=" + patient + "]";
	}

	

}