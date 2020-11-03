/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabinet.demo.entity;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 *
 * @author bk
 */

@Entity
@Table(name="Patient")
public class Patient {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;
    private Integer cinpat;
     private String fnamepat;
     private String lnamepat;
    private String sexepat;
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datenaissancepat;
     private String villepat;
     private String poidpat;
    private String mailpat;
    private Integer numtelpat;
    private String adresspat;
     private String remarquepat;
      private String maladepat;
       private String medicamentpat;
       @Temporal(javax.persistence.TemporalType.DATE)
       @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dersoinpat;
    private String motdepassepat;

    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idMedecin")
    private Medecin medecin;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Rdv> Rdvs;
    
   
    
    public Patient(){
 }

    public Patient(Integer idPatient, Integer cinpat, String fnamepat, String lnamepat, String sexepat, Date datenaissancepat, String villepat, String poidpat, String mailpat, Integer numtelpat, String adresspat, String remarquepat, String maladepat, String medicamentpat, Date dersoinpat, String motdepassepat, Integer idMedecin) {
        this.idPatient = idPatient;
        this.cinpat = cinpat;
        this.fnamepat = fnamepat;
        this.lnamepat = lnamepat;
        this.sexepat = sexepat;
        this.datenaissancepat = datenaissancepat;
        this.villepat = villepat;
        this.poidpat = poidpat;
        this.mailpat = mailpat;
        this.numtelpat = numtelpat;   
        this.adresspat = adresspat;
        this.remarquepat = remarquepat;
        this.maladepat = maladepat;
        this.medicamentpat = medicamentpat;
        this.dersoinpat = dersoinpat;
        this.motdepassepat = motdepassepat;
        this.medecin = new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null);


    }

    

  

    
    
	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public List<Rdv> getRdvs() {
        return Rdvs;
    }

    public void setRdvs(List<Rdv> Rdvs) {
        this.Rdvs = Rdvs;
    }

   

    public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public Integer getCinpat() {
		return cinpat;
	}

	public void setCinpat(Integer cinpat) {
		this.cinpat = cinpat;
	}

	public String getFnamepat() {
		return fnamepat;
	}

	public void setFnamepat(String fnamepat) {
		this.fnamepat = fnamepat;
	}

	public String getLnamepat() {
		return lnamepat;
	}

	public void setLnamepat(String lnamepat) {
		this.lnamepat = lnamepat;
	}

	public String getSexepat() {
		return sexepat;
	}

	public void setSexepat(String sexepat) {
		this.sexepat = sexepat;
	}

	public Date getDatenaissancepat() {
		return datenaissancepat;
	}

	public void setDatenaissancepat(Date datenaissancepat) {
		this.datenaissancepat = datenaissancepat;
	}

	public String getVillepat() {
		return villepat;
	}

	public void setVillepat(String villepat) {
		this.villepat = villepat;
	}

	public String getPoidpat() {
		return poidpat;
	}

	public void setPoidpat(String poidpat) {
		this.poidpat = poidpat;
	}

	public String getMailpat() {
		return mailpat;
	}

	public void setMailpat(String mailpat) {
		this.mailpat = mailpat;
	}

	public Integer getNumtelpat() {
		return numtelpat;
	}

	public void setNumtelpat(Integer numtelpat) {
		this.numtelpat = numtelpat;
	}

	public String getAdresspat() {
		return adresspat;
	}

	public void setAdresspat(String adresspat) {
		this.adresspat = adresspat;
	}

	public String getRemarquepat() {
		return remarquepat;
	}

	public void setRemarquepat(String remarquepat) {
		this.remarquepat = remarquepat;
	}

	public String getMaladepat() {
		return maladepat;
	}

	public void setMaladepat(String maladepat) {
		this.maladepat = maladepat;
	}

	public String getMedicamentpat() {
		return medicamentpat;
	}

	public void setMedicamentpat(String medicamentpat) {
		this.medicamentpat = medicamentpat;
	}

	public Date getDersoinpat() {
		return dersoinpat;
	}

	public void setDersoinpat(Date dersoinpat) {
		this.dersoinpat = dersoinpat;
	}

	public String getMotdepassepat() {
		return motdepassepat;
	}

	public void setMotdepassepat(String motdepassepat) {
		this.motdepassepat = motdepassepat;
	}

	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", cinpat=" + cinpat + ", fnamepat=" + fnamepat + ", lnamepat="
				+ lnamepat + ", sexepat=" + sexepat + ", datenaissancepat=" + datenaissancepat + ", villepat="
				+ villepat + ", poidpat=" + poidpat + ", mailpat=" + mailpat + ", numtelpat=" + numtelpat
				+ ", adresspat=" + adresspat + ", remarquepat=" + remarquepat + ", maladepat=" + maladepat
				+ ", medicamentpat=" + medicamentpat + ", dersoinpat=" + dersoinpat + ", motdepassepat=" + motdepassepat
				+ ", Rdvs=" + Rdvs + "]";
	}


	

}

