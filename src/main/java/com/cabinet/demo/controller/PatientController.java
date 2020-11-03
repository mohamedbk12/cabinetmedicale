package com.cabinet.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cabinet.demo.entity.Certificat;
import com.cabinet.demo.entity.Consultation;
import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Message;
import com.cabinet.demo.entity.Messagesec;
import com.cabinet.demo.entity.Ordonnance;
import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Rdv;
import com.cabinet.demo.entity.Secretaire;
import com.cabinet.demo.repository.CertificatRepository;
import com.cabinet.demo.repository.MedecinRepository;
import com.cabinet.demo.repository.MessageRepository;
import com.cabinet.demo.repository.MessagesecRepository;
import com.cabinet.demo.repository.OrdonnanceRepository;
import com.cabinet.demo.repository.PatientRepository;
import com.cabinet.demo.repository.RdvRepository;
import com.cabinet.demo.repository.SecretaireRepository;
import com.cabinet.demo.services.CertificatService;
import com.cabinet.demo.services.ConsultationService;
import com.cabinet.demo.services.MessageService;
import com.cabinet.demo.services.MessagesecService;
import com.cabinet.demo.services.OrdonnanceService;
import com.cabinet.demo.services.PatientService;
import com.cabinet.demo.services.RdvService;
import com.cabinet.demo.services.SecretaireService;

@Controller
@SessionAttributes({"mailMed"})
public class PatientController {
@Autowired
private PatientService patientService;
@Autowired
private PatientRepository patientRepository;
@Autowired
private RdvService rdvService;
@Autowired
private SecretaireService secretaireService;
@Autowired
private SecretaireRepository secretaireRepository;
@Autowired
private  MessageService messageService;
@Autowired
MessagesecRepository messagesecRepository;
@Autowired
private MessagesecService messagesecService;
@Autowired
private ConsultationService consultationService;
@Autowired
private OrdonnanceService ordonnanceService;
@Autowired
private CertificatService certificatService;
@Autowired
private OrdonnanceRepository ordonnanceRepository;
@Autowired
private CertificatRepository certificatRepository;
@RequestMapping("/loginpat")
public String login(HttpServletRequest request) {
	request.setAttribute("mode", "MODE_LOGIN");
	return "loginpat";
}
@RequestMapping (value="/login-patient", method = { RequestMethod.GET, RequestMethod.POST} )
public ModelAndView loginPatient(Patient patient, @RequestParam("mailpat") String mailpat, @RequestParam("motdepassepat") String motdepassepat, HttpServletRequest request) {
	 ModelAndView mv = new ModelAndView();
	if(patientService.findByMailpatAndMotdepassepat(patient.getMailpat(), patient.getMotdepassepat())!=null) {
		mv.addObject("mailpat", mailpat);
		   Integer idPatient = patientRepository.findIdMedByMailpat(mailpat).getIdPatient();
		  
	        
		   System.out.println("idPatient"+idPatient);
		   
		   mv.addObject("idPatient", idPatient);
		   String fnamepat = patientRepository.findFnameMedByMailpat(mailpat).getFnamepat();
		   System.out.println("fnamepat"+fnamepat);
			mv.addObject("fnamepat", fnamepat);
			 String lnamepat = patientRepository.findLnameMedByMailpat(mailpat).getLnamepat();
			   System.out.println("lnamepat"+lnamepat);
				mv.addObject("lnamepat", lnamepat);
				  Integer  m = null;
					m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
					   mv.addObject("m", m);
 mv.setViewName("homepatient");
 
		return mv;
	}
	else {
		request.setAttribute("error", "Invalid Email or mot de passe");
		request.setAttribute("mode", "MODE_LOGIN");
		   mv.setViewName("loginpat");
		   		return mv;
		
	}
}
@RequestMapping(value="/listrdvpat/{idPatient}")
public ModelAndView rdv(@PathVariable("idPatient") Integer idPatient) {
	ModelAndView mv = new ModelAndView("listrdvpat");
	mv.addObject(patientRepository.getOne(idPatient));
	List<Rdv> listRdvs = rdvService.getAllRdvsPat(idPatient);
	  Integer  m = null;
			m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
			   mv.addObject("m", m);
	  mv.addObject("idPatient", idPatient);
	mv.addObject("listRdvs", listRdvs);
	return mv;
}
@RequestMapping("/homepatient/{idPatient}/{idMedecin}")
public ModelAndView homepat (@PathVariable("idPatient") Integer idPatient, @PathVariable("idMedecin") Integer idMedecin, HttpServletRequest request ) {
	ModelAndView mv = new ModelAndView("homepatient");
	  Integer  m = null;
			m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
			   mv.addObject("m", m);
	return mv;
}
//set mode

@RequestMapping(value="/ajoutpatmoi/{idMedecin}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView ajoutpat(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin) {
	  ModelAndView mv = new ModelAndView("ajoutpatmoi");
	   mv.addObject("idMedecin", idMedecin);
	  
request.setAttribute("mode", "MODE_REGISTER");
	   
		return mv;
	  

}
@RequestMapping(value="/afficherpatpat/{idPatient}")
public ModelAndView patienti (@PathVariable("idPatient") Integer idPatient) {
	ModelAndView mv = new ModelAndView("afficherpatpat");
	
	mv.addObject(patientRepository.getOne(idPatient));
	Integer idMedecin = null ;
	List<Patient> listPatients = patientService.getPatientbyid(idMedecin, idPatient);
	  mv.addObject("idPatient", idPatient);
mv.addObject("listPatients", listPatients);
Integer  m = null;
m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
   mv.addObject("m", m);
	return mv;
}

//ajouter pat

@RequestMapping(value="/save-patmoi/{idMedecin}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registerPatient( Patient patient,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin,  @RequestParam("cinpat") Integer cinpat, @RequestParam("mailpat") String mailpat, @RequestParam("numtelpat") Integer numtelpat ) {
	
	  ModelAndView mv = new ModelAndView();
	   mv.addObject("idMedecin", idMedecin);
	   if (patientService.findbycin(patient.getCinpat()) == null && patientService.findbymail(patient.getMailpat()) == null && patientService.findbynum(patient.getNumtelpat()) == null ) {
		   
	   patient.setMedecin(new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null));
	   patientService.addPatient(patient);
	  
	request.setAttribute("mode", "MODE_HOME");
	mv.setViewName("ajoutpatmoi");
	return mv;
	   }
	   else {
			request.setAttribute("error", "invalide cin ou email ou numero de telephone");
			request.setAttribute("mode", "MODE_REGISTER");
			mv.setViewName("ajoutpatmoi");

			return mv;

}
}
//set mode
@RequestMapping(value="/affichersec/{idPatient}", method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView ajoutsec(HttpServletRequest request, @PathVariable("idPatient") Integer idPatient) {
	  ModelAndView mv = new ModelAndView("affichersec");
	
mv.addObject(patientRepository.getOne(idPatient));
Integer idMedecin = patientRepository.getOne(idPatient).getMedecin().getIdMedecin();
System.out.println("idMedecin"+idMedecin);
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idPatient", idPatient);
	  Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
	Integer idSec = null;
	if(secretaireRepository.findByMedecinIdMedecinOrIdSec(idMedecin, idSec) == null) {
request.setAttribute("mode", "MODE_REGISTER");
return mv;
	}
	   
	 else {
		   List<Secretaire> listSecretaires = secretaireService.getAllSecretaires(idMedecin);
		   mv.addObject("listSecretaires", listSecretaires);
		  return mv;
	  }
	  
}

// msg
@RequestMapping(value="/envoimsg/{idPatient}/{idSec}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView msgpat(HttpServletRequest request, @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec) {
	  ModelAndView mv = new ModelAndView("envoimsg");
	   mv.addObject("idPatient", idPatient);
	   mv.addObject("idSec", idSec);
	   Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
request.setAttribute("mode", "MODE_REGISTER");
	   
		return mv;
	  

}
@RequestMapping(value="/save-msg/{idPatient}/{idSec}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView msgPatient(Message message,  BindingResult bindingResult, HttpServletRequest request, @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec) {
	
	  ModelAndView mv = new ModelAndView("msgdone");
	  mv.addObject("idPatient", idPatient);
	   mv.addObject("idSec", idSec);
	   Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
	  Integer idMedecin = patientRepository.getOne(idPatient).getMedecin().getIdMedecin();
	  message.setVu("non");
 message.setSecretaire(new Secretaire(idSec, "", "", "", null, "", "", "", idMedecin));
 message.setPatient(new Patient(idPatient, null, "", "", "", null, "", null, "", null, "", "", "", "", null, "",idMedecin));
 
 messageService.addMsg(message);
	 
	   request.setAttribute("mode", "MODE_HOME");
		return mv;

}
@RequestMapping("/messagejsp/{idPatient}")
public ModelAndView message(HttpServletRequest request, @PathVariable("idPatient") Integer idPatient) {
	  ModelAndView mv = new ModelAndView("messagejsp");
	  Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
	  mv.addObject("idPatient", idPatient);
return mv;
}
@RequestMapping(value="/msgenvoi/{idPatient}")
public ModelAndView msgenvoi(@PathVariable("idPatient") Integer idPatient) {
	ModelAndView mv = new ModelAndView("msgenvoi");
	
	 Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
	List<Message> listMsgs = messageService.getAllmsg(idPatient);
	  
	  mv.addObject("idPatient", idPatient);
mv.addObject("listMsgs", listMsgs);
	return mv;
}
@RequestMapping(value="/listmsgerec/{idPatient}")
public ModelAndView msgzzen(@PathVariable("idPatient") Integer idPatient) {
	ModelAndView mv = new ModelAndView("listmsgerec");
	 Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
	
	List<Messagesec> listMsgs = messagesecService.getAllmsgsec(idPatient);
	  
	  mv.addObject("idPatient", idPatient);
	

mv.addObject("listMsgs", listMsgs);
	return mv;
}
@RequestMapping(value="/homepatient/{idPatient}")
public ModelAndView home (@PathVariable("idPatient") Integer idPatient) {
	ModelAndView mv = new ModelAndView("homepatient");
	 Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
	  mv.addObject("idPatient", idPatient);


	return mv;
}


@RequestMapping(value="/conspat/{idPatient}/{idRdv}")
public ModelAndView consultationburdv(@PathVariable("idPatient") Integer idPatient, @PathVariable("idRdv") Integer idRdv) {
	ModelAndView mv = new ModelAndView("conspat");
Integer idCons = null;
   List<Consultation> listConsultations = consultationService.getConsultationbyrdv(idRdv, idCons);
	  mv.addObject("idPatient", idPatient);
	   mv.addObject("idRdv", idRdv);
	   Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
	mv.addObject("listConsultations", listConsultations);
	return mv;
}


@RequestMapping(value="/affichercertpt/{idPatient}/{idRdv}/{idCons}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView ajoutcer(HttpServletRequest request, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	  ModelAndView mv = new ModelAndView("affichercertpt");

	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
	  Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);

		if(certificatRepository.findByConsultationIdCons(idCons)  == null) {
request.setAttribute("mode", "MODE_REGISTER");
	 return mv;
		}
		 else {
			Integer idCertificat = null;
			   List<Certificat> listCertificats = certificatService.getcert(idCons, idCertificat);
			   mv.addObject("listCertificats", listCertificats);
		 return mv;
		  }
		

}


	
@RequestMapping(value="/afficherordpt/{idPatient}/{idRdv}/{idCons}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView ajoutord(HttpServletRequest request,@PathVariable("idPatient") Integer idPatient, @PathVariable("idRdv") Integer idRdv, @PathVariable("idCons") Integer idCons) {
	  ModelAndView mv = new ModelAndView("afficherordpt");

	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
	  Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);

	  if(ordonnanceRepository.findByConsultationIdCons(idCons)  == null) {
request.setAttribute("mode", "MODE_REGISTER");
	 return mv;
	  }
	  else {
			Integer ido = null;
			   List<Ordonnance> listOrdonnances = ordonnanceService.getord(idCons, ido);
			   mv.addObject("listOrdonnances", listOrdonnances);
		 return mv;
		  }

}
@RequestMapping(value="/affmsg/{idPatient}/{idSec}/{idmsgs}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView msgpat(Messagesec messagesec, HttpServletRequest request,@PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec, @PathVariable("idmsgs") Integer idmsgs) {
	  ModelAndView mv = new ModelAndView("affmsg");
	   mv.addObject("idPatient", idPatient);
	   mv.addObject("idSec", idSec);
	   String objs = null;
	   Integer  m = null;
		m =	 messagesecRepository.countByVusAndPatientIdPatient("non", idPatient);
		   mv.addObject("m", m);
messagesecService.change(messagesec, idmsgs, objs);
		

List<Messagesec> listMsgs = messagesecService.getAllmsgsecpata(idmsgs);
	   mv.addObject("listMsgs", listMsgs);

request.setAttribute("mode", "MODE_REGISTER");
		return mv;
	  

}
}




























