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
@Table(name="Ordonnance")
public class Ordonnance {
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer ido;
     private String medicament1;
     private String det1;
      private String medicament2;
     private String det2;
      private String medicament3;
     private String det3;
      private String medicament4;
     private String det4;
      private String medicament5;
     private String det5;
      private String medicament6;
     private String det6;
      private String medicament7;
     private String det7;
      private String medicament8;
     private String det8;
      private String medicament9;
     private String det9;
      private String medicament10;
     private String det10;
     
     
    
     @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="idCons", nullable = false)
   private Consultation consultation;
     
     public Ordonnance() {
    
}

    public Ordonnance(Integer ido, String medicament1, String det1, String medicament2, String det2, String medicament3, String det3, String medicament4, String det4, String medicament5, String det5, String medicament6, String det6, String medicament7, String det7, String medicament8, String det8, String medicament9, String det9, String medicament10, String det10, Integer idCons, Integer idMedecin, Integer idPatient, Integer idRdv) {
        this.ido = ido;
        this.medicament1 = medicament1;
        this.det1 = det1;
        this.medicament2 = medicament2;
        this.det2 = det2;
        this.medicament3 = medicament3;
        this.det3 = det3;
        this.medicament4 = medicament4;
        this.det4 = det4;
        this.medicament5 = medicament5;
        this.det5 = det5;
        this.medicament6 = medicament6;
        this.det6 = det6;
        this.medicament7 = medicament7;
        this.det7 = det7;
        this.medicament8 = medicament8;
        this.det8 = det8;
        this.medicament9 = medicament9;
        this.det9 = det9;
        this.medicament10 = medicament10;
        this.det10 = det10;
        this.consultation = new Consultation(idCons, "", idMedecin, idPatient, idRdv);
    }
     
     

    public Integer getIdo() {
        return ido;
    }

    public void setIdo(Integer ido) {
        this.ido = ido;
    }

    public String getMedicament1() {
        return medicament1;
    }

    public void setMedicament1(String medicament1) {
        this.medicament1 = medicament1;
    }

    public String getDet1() {
        return det1;
    }

    public void setDet1(String det1) {
        this.det1 = det1;
    }

    public String getMedicament2() {
        return medicament2;
    }

    public void setMedicament2(String medicament2) {
        this.medicament2 = medicament2;
    }

    public String getDet2() {
        return det2;
    }

    public void setDet2(String det2) {
        this.det2 = det2;
    }

    public String getMedicament3() {
        return medicament3;
    }

    public void setMedicament3(String medicament3) {
        this.medicament3 = medicament3;
    }

    public String getDet3() {
        return det3;
    }

    public void setDet3(String det3) {
        this.det3 = det3;
    }

    public String getMedicament4() {
        return medicament4;
    }

    public void setMedicament4(String medicament4) {
        this.medicament4 = medicament4;
    }

    public String getDet4() {
        return det4;
    }

    public void setDet4(String det4) {
        this.det4 = det4;
    }

    public String getMedicament5() {
        return medicament5;
    }

    public void setMedicament5(String medicament5) {
        this.medicament5 = medicament5;
    }

    public String getDet5() {
        return det5;
    }

    public void setDet5(String det5) {
        this.det5 = det5;
    }

    public String getMedicament6() {
        return medicament6;
    }

    public void setMedicament6(String medicament6) {
        this.medicament6 = medicament6;
    }

    public String getDet6() {
        return det6;
    }

    public void setDet6(String det6) {
        this.det6 = det6;
    }

    public String getMedicament7() {
        return medicament7;
    }

    public void setMedicament7(String medicament7) {
        this.medicament7 = medicament7;
    }

    public String getDet7() {
        return det7;
    }

    public void setDet7(String det7) {
        this.det7 = det7;
    }

    public String getMedicament8() {
        return medicament8;
    }

    public void setMedicament8(String medicament8) {
        this.medicament8 = medicament8;
    }

    public String getDet8() {
        return det8;
    }

    public void setDet8(String det8) {
        this.det8 = det8;
    }

    public String getMedicament9() {
        return medicament9;
    }

    public void setMedicament9(String medicament9) {
        this.medicament9 = medicament9;
    }

    public String getDet9() {
        return det9;
    }

    public void setDet9(String det9) {
        this.det9 = det9;
    }

    public String getMedicament10() {
        return medicament10;
    }

    public void setMedicament10(String medicament10) {
        this.medicament10 = medicament10;
    }

    public String getDet10() {
        return det10;
    }

    public void setDet10(String det10) {
        this.det10 = det10;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "Ordonnance{" + "ido=" + ido + ", medicament1=" + medicament1 + ", det1=" + det1 + ", medicament2=" + medicament2 + ", det2=" + det2 + ", medicament3=" + medicament3 + ", det3=" + det3 + ", medicament4=" + medicament4 + ", det4=" + det4 + ", medicament5=" + medicament5 + ", det5=" + det5 + ", medicament6=" + medicament6 + ", det6=" + det6 + ", medicament7=" + medicament7 + ", det7=" + det7 + ", medicament8=" + medicament8 + ", det8=" + det8 + ", medicament9=" + medicament9 + ", det9=" + det9 + ", medicament10=" + medicament10 + ", det10=" + det10 + ", consultation=" + consultation + '}';
    }
     
}
