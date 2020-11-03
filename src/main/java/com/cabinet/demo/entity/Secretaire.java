/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabinet.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author bk
 */

@Entity
@Table(name="Secretaire")
public class Secretaire {
    @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSec;

    private String fnameSec;

    private String lnameSec;

    private String mailSec;

    private Integer numSec;

    private String adressSec;

    private String sexeSec;
   
    private String motdepassSecc;
  
   @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="idMedecin", nullable = false)
    private Medecin medecin;
    
   

    public Secretaire() {
    
}

    public Secretaire(Integer idSec, String fnameSec, String lnameSec, String mailSec, Integer numSec, String adressSec,
			String sexeSec, String motdepassSecc, Integer idMedecin) {
    	this.idSec = idSec;
		this.fnameSec = fnameSec;
		this.lnameSec = lnameSec;
		this.mailSec = mailSec;
		this.numSec = numSec;
		this.adressSec = adressSec;
		this.sexeSec = sexeSec;
		this.motdepassSecc = motdepassSecc;
        this.medecin = new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null);
    }


 

public Medecin getMedecin() {
        return medecin;
    }
    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    
    public Integer getIdSec() {
		return idSec;
	}

	public void setIdSec(Integer idSec) {
		this.idSec = idSec;
	}

	public String getFnameSec() {
		return fnameSec;
	}

	public void setFnameSec(String fnameSec) {
		this.fnameSec = fnameSec;
	}

	public String getLnameSec() {
		return lnameSec;
	}

	public void setLnameSec(String lnameSec) {
		this.lnameSec = lnameSec;
	}

	public String getMailSec() {
		return mailSec;
	}

	public void setMailSec(String mailSec) {
		this.mailSec = mailSec;
	}

	public Integer getNumSec() {
		return numSec;
	}

	public void setNumSec(Integer numSec) {
		this.numSec = numSec;
	}

	public String getAdressSec() {
		return adressSec;
	}

	public void setAdressSec(String adressSec) {
		this.adressSec = adressSec;
	}

	public String getSexeSec() {
		return sexeSec;
	}

	public void setSexeSec(String sexeSec) {
		this.sexeSec = sexeSec;
	}

	public String getMotdepassSecc() {
		return motdepassSecc;
	}

	public void setMotdepassSecc(String motdepassSecc) {
		this.motdepassSecc = motdepassSecc;
	}

	@Override
	public String toString() {
		return "Secretaire [idSec=" + idSec + ", fnameSec=" + fnameSec + ", lnameSec=" + lnameSec + ", mailSec="
				+ mailSec + ", numSec=" + numSec + ", adressSec=" + adressSec + ", sexeSec=" + sexeSec
				+ ", motdepassSecc=" + motdepassSecc + ", medecin=" + medecin + "]";
	}


    
    

}