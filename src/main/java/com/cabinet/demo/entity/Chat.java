package com.cabinet.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Chat {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idchat;
  private String mes;
  private String role;
  
  @JsonBackReference
  @ManyToOne( fetch = FetchType.LAZY)
  @JoinColumn(name = "idSec")
  private Secretaire secretaire;
  @JsonBackReference
  @ManyToOne( fetch = FetchType.LAZY)
  @JoinColumn(name = "idMedecin")
  private Medecin medecin;

  public Chat () {
	  
  }

public Chat(Integer idchat, String mes, String role,Integer idSec, Integer idMedecin) {
	super();
	this.idchat = idchat;
	this.mes = mes;
	this.role = role;
	this.secretaire = new Secretaire(idSec, "", "", "", null, "", "", "", idMedecin);
	this.medecin =new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null);
}

public Integer getIdchat() {
	return idchat;
}

public void setIdchat(Integer idchat) {
	this.idchat = idchat;
}

public String getMes() {
	return mes;
}

public void setMes(String mes) {
	this.mes = mes;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public Secretaire getSecretaire() {
	return secretaire;
}

public void setSecretaire(Secretaire secretaire) {
	this.secretaire = secretaire;
}

public Medecin getMedecin() {
	return medecin;
}

public void setMedecin(Medecin medecin) {
	this.medecin = medecin;
}

@Override
public String toString() {
	return "Chat [idchat=" + idchat + ", mes=" + mes + ", role=" + role + ", secretaire=" + secretaire + ", medecin="
			+ medecin + "]";
}

}
