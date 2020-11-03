package com.cabinet.demo.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cabinet.demo.entity.Certificat;
import com.cabinet.demo.entity.Chat;
import com.cabinet.demo.entity.Consultation;
import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Messagesec;
import com.cabinet.demo.entity.Ordonnance;
import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Rdv;
import com.cabinet.demo.entity.Secretaire;
import com.cabinet.demo.repository.CertificatRepository;
import com.cabinet.demo.repository.ChatRepository;
import com.cabinet.demo.repository.ConsultationRepository;
import com.cabinet.demo.repository.MedecinRepository;
import com.cabinet.demo.repository.OrdonnanceRepository;
import com.cabinet.demo.repository.PatientRepository;
import com.cabinet.demo.repository.RdvRepository;
import com.cabinet.demo.repository.SecretaireRepository;
import com.cabinet.demo.services.CertificatService;
import com.cabinet.demo.services.ChatService;
import com.cabinet.demo.services.ConsultationService;
import com.cabinet.demo.services.MedecinService;
import com.cabinet.demo.services.OrdonnanceService;
import com.cabinet.demo.services.PatientService;
import com.cabinet.demo.services.RdvService;
import com.cabinet.demo.services.SecretaireService;



@Controller

public class MedecinController {

	@Autowired	
	private MedecinService medecinService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private MedecinRepository medecinRepository;
	@Autowired
	private RdvService rdvService;
	@Autowired
	private ConsultationService consultationService;
	@Autowired
	private SecretaireService secretaireService;
	@Autowired
	private SecretaireRepository secretaireRepository;
	@Autowired
	private RdvRepository rdvRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ConsultationRepository consultationRepository;
	@Autowired
	private CertificatRepository certificatRepository;
	@Autowired
	private CertificatService certificatService;
	
	@Autowired
	private OrdonnanceService ordonnanceService;
	@Autowired
	OrdonnanceRepository ordonnanceRepository;
	@Autowired
	ChatService chatService;
	
	@Autowired
	ChatRepository chatRepository;
	
	
	
@RequestMapping("/allmedecin")
	
	public String home (Model model)
	{
  List<Medecin> listMedecins = new ArrayList<Medecin>();
 
listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
		return "allmedecin";
		}

@RequestMapping(value="/chose", method = { RequestMethod.GET, RequestMethod.POST})
public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "chose";
}
@RequestMapping(value="/profil/{idMedecin}", method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView profilc(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin) {
	  ModelAndView mv = new ModelAndView("profil");
	   mv.addObject("idMedecin", idMedecin);
	  String specilMed = null;
		   List<Medecin> listMedecins = medecinService.findone(idMedecin, specilMed);
		   mv.addObject("listMedecins", listMedecins);
		  return mv;
	 
	  
}
	  
// set mode
@RequestMapping(value="/ajoutsec/{idMedecin}", method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView ajoutsec(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin) {
	  ModelAndView mv = new ModelAndView("ajoutsec");
	   mv.addObject("idMedecin", idMedecin);
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
	  


// ajouter sec

@RequestMapping(value="/save-sec/{idMedecin}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registerSecretaire( Secretaire secretaire,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @RequestParam("numSec") Integer numSec, @RequestParam("mailSec") String mailSec) {
	
	  ModelAndView mv = new ModelAndView();
	   mv.addObject("idMedecin", idMedecin);
	   if (secretaireService.findbnumSec(secretaire.getNumSec()) == null && secretaireService.findbymail(secretaire.getMailSec()) == null) {
    secretaire.setMedecin(new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null));
	secretaireService.addSecretaire(secretaire);
	request.setAttribute("mode", "MODE_HOME");
	mv.setViewName("medsec");
	return mv;
	
	} else {
		request.setAttribute("error", "invalide email ou numero de telephone");
		request.setAttribute("mode", "MODE_REGISTER");
		mv.setViewName("ajoutsec");
		return mv;
	}
	
}

@RequestMapping(value="/save-medecin" , method = { RequestMethod.GET, RequestMethod.POST})
public String registerMedecin(@ModelAttribute Medecin medecin, BindingResult bindingResult, HttpServletRequest request, @RequestParam("mailMed") String mailMed, @RequestParam("numMed") Integer numMed) {
	if( medecinService.findmail(medecin.getMailMed()) == null && medecinService.findnumMed(medecin.getNumMed()) == null) {
		
	medecinService.saveMedecin(medecin);
	request.setAttribute("mode", "MODE_HOME");
	return "chose";
	
		}	
		 else {
		request.setAttribute("error", "invalide email ou numero de telephone");
		request.setAttribute("mode", "MODE_REGISTER");
		return "chose";
	}
}
@RequestMapping("/loginmed")
public String login(HttpServletRequest request) {
	request.setAttribute("mode", "MODE_LOGIN");
	return "loginmed";
}
@RequestMapping (value ="/login-medecin" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView loginMedecin(Medecin medecin, @RequestParam("mailMed") String mailMed, @RequestParam("motdepassMed") String motdepassMed, HttpServletRequest request) {
	  ModelAndView mv = new ModelAndView();
	if(medecinService.findByMailMedAndMotdepassMed(medecin.getMailMed(), medecin.getMotdepassMed())!=null) {
 
   mv.addObject("mailMed", mailMed);
   Integer idMedecin = medecinRepository.findIdMedByMailMed(mailMed).getIdMedecin();
   System.out.println("idMedecin"+idMedecin);
   mv.addObject("idMedecin", idMedecin);
   mv.setViewName("homemedecin");
		return mv ;
	}
	else {
		request.setAttribute("error", "Invalid Email or Mot de passe");
		request.setAttribute("mode", "MODE_LOGIN");
		mv.setViewName("loginmed");
		return mv ;
		
	}
}


@RequestMapping(value="/listpatient/{idMedecin}")
public ModelAndView patient(@PathVariable("idMedecin") Integer idMedecin, Integer idPatient) {
	ModelAndView mv = new ModelAndView("listpatient");
	
	mv.addObject(medecinRepository.getOne(idMedecin));
	
	List<Patient> listPatients = patientService.getAllPatients(idMedecin);
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idPatient", idPatient);
mv.addObject("listPatients", listPatients);
	return mv;
}

@RequestMapping(value="/afficherpatient/{idMedecin}/{idPatient}")
public ModelAndView patientidmed (@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient) {
	ModelAndView mv = new ModelAndView("afficherpatient");
	
	mv.addObject(medecinRepository.getOne(idMedecin));
	mv.addObject(medecinRepository.getOne(idPatient));
	List<Patient> listPatients = patientService.getPatientbymedandapt(idMedecin, idPatient);
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idPatient", idPatient);
mv.addObject("listPatients", listPatients);
	return mv;
}
@RequestMapping(value="/fiche/{idMedecin}/{idPatient}")
public ModelAndView fiche (@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient) {
	ModelAndView mv = new ModelAndView("fiche");
	
	mv.addObject(medecinRepository.getOne(idMedecin));
	mv.addObject(medecinRepository.getOne(idPatient));
	List<Patient> listPatients = patientService.getPatientbymedandapt(idMedecin, idPatient);
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idPatient", idPatient);
mv.addObject("listPatients", listPatients);
	return mv;
}
@RequestMapping("/homemedecin/{idMedecin}")
public ModelAndView homemed (@PathVariable("idMedecin") Integer idMedecin) {
	ModelAndView mv = new ModelAndView("homemedecin");
	return mv;
}
//set mode

@RequestMapping(value="/ajoutpat/{idMedecin}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView ajoutpat(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin) {
	  ModelAndView mv = new ModelAndView("ajoutpat");
	   mv.addObject("idMedecin", idMedecin);
	  
request.setAttribute("mode", "MODE_REGISTER");
	   
		return mv;
	  

}

// ajouter pat

@RequestMapping(value="/save-pat/{idMedecin}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registerPatient( Patient patient,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @RequestParam("cinpat") Integer cinpat, @RequestParam("mailpat") String mailpat, @RequestParam("numtelpat") Integer numtelpat ) {
	
	  ModelAndView mv = new ModelAndView();
	   mv.addObject("idMedecin", idMedecin);
	   
	   if (patientService.findbycin(patient.getCinpat()) == null && patientService.findbymail(patient.getMailpat()) == null && patientService.findbynum(patient.getNumtelpat()) == null ) {
		   
	   patient.setMedecin(new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null));
	   patientService.addPatient(patient);
	request.setAttribute("mode", "MODE_HOME");
	mv.setViewName("patientajouter");
	return mv;
	   }
	else {
		request.setAttribute("error", "invalide cin ou email ou numero de telephone");
		request.setAttribute("mode", "MODE_REGISTER");
		mv.setViewName("ajoutpat");

		return mv;

	}
	   
}
//set mode modifier patient

@RequestMapping(value="/modifierpat/{idMedecin}/{idPatient}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView modifierpat(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient) {
	  ModelAndView mv = new ModelAndView("modifierpat");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idPatient", idPatient);
	  
request.setAttribute("mode", "MODE_REGISTER");
	   
		return mv;
	  

}

//mod pat

@RequestMapping(value="/save-pat/{idMedecin}/{idPatient}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registerPatient( Patient patient, Medecin medecin,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient) {
	
	  ModelAndView mv = new ModelAndView();
	  
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idPatient", idPatient);
	   if (patientService.findbycin(patient.getCinpat()) == null && patientService.findbymail(patient.getMailpat()) == null && patientService.findbynum(patient.getNumtelpat()) == null ) {
		   
	  patient.setMedecin(medecin);
	   patientService.updatePatient(idPatient, patient);
	  
	request.setAttribute("mode", "MODE_HOME");
	mv.setViewName("modifier");
	return mv;
	   }
	   else {
			request.setAttribute("error", "invalide cin ou email ou numero de telephone");
			request.setAttribute("mode", "MODE_REGISTER");
			mv.setViewName("modifierpat");

			return mv;

}
	
}



// rdv modifier
@RequestMapping(value="/modifierrdv/{idMedecin}/{idPatient}/{idRdv}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView modifierrdv(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient, @PathVariable("idRdv") Integer idRdv) {
	  ModelAndView mv = new ModelAndView("modifierrdv");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idPatient", idPatient);
	   mv.addObject("idRdv", idRdv);
request.setAttribute("mode", "MODE_REGISTER");
	   
		return mv;
	  

}

//ajouter pat

@RequestMapping(value="/save-rdvm/{idMedecin}/{idPatient}/{idRdv}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView modradv( Rdv rdv, Medecin medecin, Patient patient,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient, @PathVariable("idRdv") Integer idRdv, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("dateRdv") Date dateRdv, @RequestParam("timeRdv") Time timeRdv) {
	
	  ModelAndView mv = new ModelAndView();
	  
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idPatient", idPatient);
	   mv.addObject("idRdv", idRdv);
	   if (rdvService.getrdvbybyby(idMedecin, dateRdv, timeRdv) == null) {
		   
	   rdvService.updaterdv(idRdv, rdv);
	  
	request.setAttribute("mode", "MODE_HOME");
	mv.setViewName("rdvmodifier");
	return mv;
	   }
	   else {
			request.setAttribute("error", "rendez vous deja réservé");
			request.setAttribute("mode", "MODE_REGISTER");
			mv.setViewName("modifierrdv");

			return mv;

}
	
}

//set mode rdv 

@RequestMapping(value="/ajouterrdv/{idMedecin}/{idPatient}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView ajoutrdv(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient) {
	  ModelAndView mv = new ModelAndView("ajouterrdv");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idPatient", idPatient);
request.setAttribute("mode", "MODE_REGISTER");
mv.setViewName("ajouterrdv");
	 return mv;
	  

}

//ajouter rdv

@RequestMapping(value="/save-rdv/{idMedecin}/{idPatient}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registerRdv( Rdv rdv,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("dateRdv") Date dateRdv, @RequestParam("timeRdv") Time timeRdv) {
	
	  ModelAndView mv = new ModelAndView();
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idPatient", idPatient);
	if(rdvService.getrdvbybyby(idMedecin, dateRdv, timeRdv) == null || rdvService.getrdvbybyby(idMedecin, dateRdv, timeRdv).getTimeRdv() + "00:15:00" == null) {
		
	   rdv.setMedecin(new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null));
       rdv.setPatient(new Patient(idPatient, null, "", "", "", null, "", null, "", null, "", "", "", "", null, "", idMedecin));
       
        rdvService.addRdv(rdv);
        
	request.setAttribute("mode", "MODE_HOME");
	mv.setViewName("rdvajouter");
	return mv;
	}	 else {
		request.setAttribute("error", "rendez vous deja réservé");
		request.setAttribute("mode", "MODE_REGISTER");
		mv.setViewName("ajouterrdv");
		return mv;
	}
	
}

//set mode consultation

@RequestMapping(value="/ajoutercons/{idMedecin}/{idPatient}/{idRdv}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView ajoutcons(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient,  @PathVariable("idRdv") Integer idRdv) {
	  ModelAndView mv = new ModelAndView("ajoutercons");
	 mv.addObject("idPatient", idPatient);
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idRdv", idRdv);
		if(consultationRepository.findByRdvIdRdv(idRdv)  == null) {

request.setAttribute("mode", "MODE_REGISTER");
mv.setViewName("ajoutercons");
	 return mv;
		} else if(consultationRepository.findByRdvIdRdv(idRdv)  != null) {
			request.setAttribute("mode", "MODE_HOME");
	
		}
		 return mv;

}

//ajouter rdv

@RequestMapping(value="/save-cons/{idMedecin}/{idPatient}/{idRdv}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registercons( Consultation consultation ,  BindingResult bindingResult, HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient,  @PathVariable("idRdv") Integer idRdv) {
	
	  ModelAndView mv = new ModelAndView("consajouter");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idRdv", idRdv);
	   mv.addObject("idPatient", idPatient);
	  
	consultation.setRdv(new Rdv(idRdv, null, null, null, null, null, idMedecin, idPatient));
	consultation.setMedecin(new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null));
	      consultationService.addConsultation(consultation);
	request.setAttribute("mode", "MODE_HOME");
	return mv;
	
	
}

@RequestMapping(value="/supprimerpat/{idMedecin}/{idPatient}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView supppat( Patient patient,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient) {
	
	  ModelAndView mv = new ModelAndView("patientsupp");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idPatient", idPatient);
patientService.delete(idPatient);

	return mv;
	
	
}
@RequestMapping(value="/suppsec/{idMedecin}/{idSec}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView supsec( Secretaire secretaire,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idSec") Integer idSec) {
	
	  ModelAndView mv = new ModelAndView("secsupp");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idSec", idSec);
	   secretaireService.delete(idSec);

	return mv;
	
	
}
@RequestMapping(value="/supprimerrdv/{idMedecin}/{idRdv}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView supprdv( Rdv rdv,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idRdv") Integer idRdv) {
	
	  ModelAndView mv = new ModelAndView("rdvsupprimer");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idRdv", idRdv);
rdvService.delete(idRdv);

	return mv;
	
	
}




@RequestMapping(value="/listrdv/{idMedecin}")
public ModelAndView rdv(@PathVariable("idMedecin") Integer idMedecin) {
	ModelAndView mv = new ModelAndView("listrdv");
	mv.addObject(medecinRepository.getOne(idMedecin));
	List<Rdv> listRdvs = rdvService.getAllRdvsda(idMedecin);
	
	  mv.addObject("idMedecin", idMedecin);
	mv.addObject("listRdvs", listRdvs);
	return mv;
}
@RequestMapping(value="/list/{idMedecin}/", method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView recherchrrdv(Rdv rdv, @PathVariable("idMedecin") Integer idMedecin,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("dateRdv") Date dateRdv, HttpServletRequest request) {
	ModelAndView mv = new ModelAndView("result");
	mv.addObject(medecinRepository.getOne(idMedecin));
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("dateRdv", dateRdv);

	List<Rdv> listRdvs = rdvService.recherche(idMedecin, dateRdv);
	mv.addObject("listRdvs", listRdvs);
	return mv;
}
@RequestMapping(value="/listpat/{idMedecin}/", method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView recherchrrdv(Patient patient, @PathVariable("idMedecin") Integer idMedecin, @RequestParam("lnamepat") String lnamepat, HttpServletRequest request) {
	ModelAndView mv = new ModelAndView("resultpat");
	mv.addObject(medecinRepository.getOne(idMedecin));
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("lnamepat", lnamepat);

	List<Patient> listPatients = patientService.getrcherche(idMedecin, lnamepat);
	mv.addObject("listPatients", listPatients);
	return mv;
}
@RequestMapping(value="/listpati/{idMedecin}/", method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView recherchrpat(Patient patient, @PathVariable("idMedecin") Integer idMedecin, @RequestParam("cinpat") Integer cinpat, HttpServletRequest request) {
	ModelAndView mv = new ModelAndView("resultpat");
	mv.addObject(medecinRepository.getOne(idMedecin));
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("cinpat", cinpat);

	List<Patient> listPatients = patientService.getrcherchecin(idMedecin, cinpat);
	mv.addObject("listPatients", listPatients);
	return mv;
}

@RequestMapping(value="/todayrdv/{idMedecin}")
public ModelAndView todayrdv(@PathVariable("idMedecin") Integer idMedecin) {
	ModelAndView mv = new ModelAndView("todayrdv");
	mv.addObject(medecinRepository.getOne(idMedecin));
	

	List<Rdv> listRdvs = rdvService.getAllRdvs(idMedecin);
	
	  mv.addObject("idMedecin", idMedecin);
	mv.addObject("listRdvs", listRdvs);
	return mv;
}
@RequestMapping(value="/listconsultation/{idMedecin}")
public ModelAndView consultation(@PathVariable("idMedecin") Integer idMedecin) {
	ModelAndView mv = new ModelAndView("listconsultation");
	mv.addObject(medecinRepository.getOne(idMedecin));

   List<Consultation> listConsultations = consultationService.getAllConsultations(idMedecin);
	  mv.addObject("idMedecin", idMedecin);
	mv.addObject("listConsultations", listConsultations);
	return mv;
}


@RequestMapping(value="/affichercons/{idMedecin}/{idRdv}/{idPatient}/{idCons}")
public ModelAndView afficherconsultation(@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	ModelAndView mv = new ModelAndView("affichercons");
	mv.addObject(medecinRepository.getOne(idMedecin));
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
   List<Consultation> listConsultations = consultationService.getConsultation(idCons);
	
	mv.addObject("listConsultations", listConsultations);
	return mv;
}
//set mode modifier cons

@RequestMapping(value="/modcons/{idMedecin}/{idRdv}/{idPatient}/{idCons}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView modifiercons(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	  ModelAndView mv = new ModelAndView("modcons");
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
request.setAttribute("mode", "MODE_REGISTER");
		return mv;
}

//mod pat

@RequestMapping(value="/mod-cons/{idMedecin}/{idRdv}/{idPatient}/{idCons}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView modcons(Consultation consultation, Medecin medecin,Rdv rdv,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	
	  ModelAndView mv = new ModelAndView();
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
	  
	 
	  consultationService.updatecons(idCons, consultation);
	  
	request.setAttribute("mode", "modif");
	mv.setViewName("conssupp");
	return mv;
	  
}



@RequestMapping(value="/suppcons/{idMedecin}/{idRdv}/{idPatient}/{idCons}")
public ModelAndView suppconsultation(HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	ModelAndView mv = new ModelAndView("conssupp");
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
  consultationService.delete(idCons);
	request.setAttribute("mode", "supp");


	return mv;
}
//set mode cons

@RequestMapping(value="/ajoutercert/{idMedecin}/{idRdv}/{idPatient}/{idCons}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView ajoutcer(HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	  ModelAndView mv = new ModelAndView("ajoutercert");
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
		if(certificatRepository.findByConsultationIdCons(idCons)  == null) {
request.setAttribute("mode", "MODE_REGISTER");
mv.setViewName("ajoutercert");
	 return mv;
		}
		 else {
			Integer idCertificat = null;
			   List<Certificat> listCertificats = certificatService.getcert(idCons, idCertificat);
			   mv.addObject("listCertificats", listCertificats);
		 return mv;
		  }

}

//ajouter rdv

@RequestMapping(value="/save-cert/{idMedecin}/{idRdv}/{idPatient}/{idCons}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registercert(Certificat certificat  ,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	
	  ModelAndView mv = new ModelAndView("certajouter");
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
	  
	  certificat.setConsultation(new Consultation(idCons, "",  idMedecin, idPatient, idRdv));
	    certificatService.addCertificat(certificat);
	request.setAttribute("mode", "MODE_HOME");
	return mv;
	
	
}

//set mode ord

@RequestMapping(value="/ajouterord/{idMedecin}/{idRdv}/{idPatient}/{idCons}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView ajoutord(HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	  ModelAndView mv = new ModelAndView("ajouterord");
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
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

//ajouter rdv

@RequestMapping(value="/save-ord/{idMedecin}/{idRdv}/{idPatient}/{idCons}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registerord(Ordonnance ordonnance  ,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons) {
	
	  ModelAndView mv = new ModelAndView("ordajouter");
	  mv.addObject("idMedecin", idMedecin);
	  mv.addObject("idRdv", idRdv);
	  mv.addObject("idPatient", idPatient);
	  mv.addObject("idCons", idCons);
	  
	  ordonnance.setConsultation(new Consultation(idCons, "",  idMedecin, idPatient, idRdv));
	  ordonnanceService.addOrdonnance(ordonnance);
	request.setAttribute("mode", "MODE_HOME");
	return mv;
	
	
}




//@RequestMapping("/{mailMed}/listpatient")
//public String list (Model model, @PathVariable("mailMed") String mailMed)
//{
//List<Patient> listPatients = new ArrayList<Patient>();

//listPatients= patientService.findByMailMed(mailMed);
//
//model.addAllAttributes(listPatients);
//model.addAttribute("listPatients", listPatients);
	//return "listpatient";
	//}
	

@RequestMapping("medecincategorie")
public String hello() {
	return "medecincategorie";
}
@RequestMapping("/cardiologue")
public String gat1 (Model model)
{
List<Medecin> listMedecins = new ArrayList<Medecin>();

listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
	return "cardiologue";
	}

@RequestMapping("/dentiste")
public String gat2 (Model model)
{
List<Medecin> listMedecins = new ArrayList<Medecin>();

listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
	return "dentiste";
	}

@RequestMapping("/dermatologue")
public String gat3 (Model model)
{
List<Medecin> listMedecins = new ArrayList<Medecin>();

listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
	return "dermatologue";
	}
@RequestMapping("/generaliste")
public String gat4 (Model model)
{
List<Medecin> listMedecins = new ArrayList<Medecin>();

listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
	return "generaliste";
	}
@RequestMapping("/ophtalmologue")
public String gat5 (Model model)
{
List<Medecin> listMedecins = new ArrayList<Medecin>();

listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
	return "ophtalmologue";
	}
@RequestMapping("/pediatre")
public String gat6 (Model model)
{
List<Medecin> listMedecins = new ArrayList<Medecin>();

listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
	return "pediatre";
	}
@RequestMapping("/sage")
public String gat7 (Model model)
{
List<Medecin> listMedecins = new ArrayList<Medecin>();

listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
	return "sage";
	}
@RequestMapping("/psychiatre")
public String gat8 (Model model)
{
List<Medecin> listMedecins = new ArrayList<Medecin>();

listMedecins= medecinService.getAllMedecins();

model.addAttribute("listMedecins", listMedecins);
	return "psychiatre";
	}



//set mode modifier patient

@RequestMapping(value="/modifiermed/{idMedecin}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView modifiermed(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin) {
	  ModelAndView mv = new ModelAndView("modifiermed");
	   mv.addObject("idMedecin", idMedecin);
	
	  
request.setAttribute("mode", "MODE_REGISTER");
	   
		return mv;
	  

}

//mod pat

@RequestMapping(value="/save-med/{idMedecin}" , method = { RequestMethod.GET, RequestMethod.POST})
public ModelAndView registermed( Medecin medecin,Consultation consultations,Rdv rdv, Patient patient, Secretaire secretaire, BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin) {
	
	  ModelAndView mv = new ModelAndView();
	  
	   mv.addObject("idMedecin", idMedecin);

	 medecinService.updatemedecin(idMedecin, medecin);
	  
	request.setAttribute("mode", "promo");
	mv.setViewName("profil");
	return mv;

	
}
///// chatt 
@RequestMapping(value="/chat/{idMedecin}/{idSec}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView chat(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
	  ModelAndView mv = new ModelAndView("chat");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idSec", idSec);
	   //liste msg
	   List<Chat> listChat = chatService.getall(idSec, idMedecin);
	   mv.addObject("listChat", listChat);

	   
		return mv;
	  

}
///// chaatttt 
@RequestMapping(value="/save-chat/{idMedecin}/{idSec}", method = {RequestMethod.POST} )
public ModelAndView envoi(Chat chat,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
	ModelAndView mv = new ModelAndView();
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idSec", idSec);
	 chat.setMedecin(new Medecin (idMedecin, "", "", "", null, "", "", "", "", "", null));
	   chat.setSecretaire(new Secretaire(idSec, "", "", "", null, "", "", "", idMedecin));
	   chat.setRole("medecin"); 
	
	   chatRepository.saveAndFlush(chat);
	   mv.setViewName("chat");
	   //liste msg
	   List<Chat> listChat = chatService.getall(idSec, idMedecin);
	   mv.addObject("listChat", listChat);
	
	return mv;
}

}
