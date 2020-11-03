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
@Table(name="Message")
public class Message {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idmsg;
     private String obj;
     private String msg;

     private String vu ;
     
     @JsonBackReference
     @ManyToOne( fetch = FetchType.LAZY)
     @JoinColumn(name = "idSec")
     private Secretaire secretaire;
     @JsonBackReference
     @ManyToOne( fetch = FetchType.LAZY)
     @JoinColumn(name = "idPatient")
     private Patient patient;
     
     public Message() {
    	 
     }

	public Message(Integer idmsg, String obj, String msg,String vu, Integer idPatient, Integer idSec, Integer idMedecin) {
		super();
		this.idmsg = idmsg;
		this.obj = obj;
		this.msg = msg;
		this.vu = vu;
		this.secretaire = new Secretaire(idSec, "", "", "", null, "", "", "", idMedecin);
		this.patient = new Patient(idPatient, null, "", "", "", null, "", null, "", null, "", "", "", "", null, "",idMedecin);
	}

	public Integer getIdmsg() {
		return idmsg;
	}

	public void setIdmsg(Integer idmsg) {
		this.idmsg = idmsg;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getVu() {
		return vu;
	}

	public void setVu(String vu) {
		this.vu = vu;
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
		return "Message [idmsg=" + idmsg + ", obj=" + obj + ", msg=" + msg + ", vu=" + vu + ", secretaire=" + secretaire + ", patient="
				+ patient + "]";
	}
     
}
