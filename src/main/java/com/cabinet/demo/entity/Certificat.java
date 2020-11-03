/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabinet.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author bk
 */

@Entity
@Table(name="Certificat")
public class Certificat {
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idCertificat;
    @Temporal(javax.persistence.TemporalType.DATE)
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date findate;
    @Temporal(javax.persistence.TemporalType.DATE)
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datejour;
   private String remarq;
   
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="idCons", nullable = false)
   private Consultation consultation;
    
    public Certificat(){
        
    }

    public Certificat(Integer idCertificat, Date findate, Date datejour, String remarq, Integer idCons, Integer idMedecin, Integer idPatient, Integer idRdv) {
        this.idCertificat = idCertificat;
        this.findate = findate;
        this.datejour = datejour;
        this.remarq = remarq;
        this.consultation = new Consultation(idCertificat, "", idMedecin, idPatient, idRdv);
    }

    

    public Integer getIdCertificat() {
		return idCertificat;
	}

	public void setIdCertificat(Integer idCertificat) {
		this.idCertificat = idCertificat;
	}

	public Date getFindate() {
		return findate;
	}

	public void setFindate(Date findate) {
		this.findate = findate;
	}

	public Date getDatejour() {
		return datejour;
	}

	public void setDatejour(Date datejour) {
		this.datejour = datejour;
	}

	public String getRemarq() {
		return remarq;
	}

	public void setRemarq(String remarq) {
		this.remarq = remarq;
	}

	public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

	@Override
	public String toString() {
		return "Certificat [idCertificat=" + idCertificat + ", findate=" + findate + ", datejour=" + datejour
				+ ", remarq=" + remarq + ", consultation=" + consultation + "]";
	}

    
    
}
