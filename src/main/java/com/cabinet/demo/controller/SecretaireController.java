package com.cabinet.demo.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cabinet.demo.entity.Certificat;
import com.cabinet.demo.entity.Chat;
import com.cabinet.demo.entity.Consultation;
import com.cabinet.demo.entity.Medecin;
import com.cabinet.demo.entity.Message;
import com.cabinet.demo.entity.Messagesec;
import com.cabinet.demo.entity.Ordonnance;
import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.entity.Rdv;
import com.cabinet.demo.entity.Secretaire;
import com.cabinet.demo.repository.CertificatRepository;
import com.cabinet.demo.repository.ChatRepository;
import com.cabinet.demo.repository.ConsultationRepository;
import com.cabinet.demo.repository.MedecinRepository;
import com.cabinet.demo.repository.MessageRepository;
import com.cabinet.demo.repository.MessagesecRepository;
import com.cabinet.demo.repository.OrdonnanceRepository;
import com.cabinet.demo.repository.PatientRepository;
import com.cabinet.demo.repository.RdvRepository;
import com.cabinet.demo.repository.SecretaireRepository;
import com.cabinet.demo.services.CertificatService;
import com.cabinet.demo.services.ChatService;
import com.cabinet.demo.services.ConsultationService;
import com.cabinet.demo.services.MedecinService;
import com.cabinet.demo.services.MessageService;
import com.cabinet.demo.services.MessagesecService;
import com.cabinet.demo.services.OrdonnanceService;
import com.cabinet.demo.services.PatientService;
import com.cabinet.demo.services.RdvService;
import com.cabinet.demo.services.SecretaireService;


@Controller
public class SecretaireController {

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
	OrdonnanceRepository ordonnanceRepository;
	@Autowired
	private OrdonnanceService ordonnanceService;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	private MessageService messageService;
	@Autowired
	MessagesecRepository messagesecRepository;
	@Autowired
	private MessagesecService messagesecService;
	@Autowired
	ChatService chatService;
	
	@Autowired
	ChatRepository chatRepository;
	@RequestMapping("/loginsec")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "loginsec";
	}
	@RequestMapping ("/login-secretaire")
	public ModelAndView loginPatient(Secretaire secretaire, @RequestParam("mailSec") String mailSec, @RequestParam("motdepassSecc") String motdepassSecc, HttpServletRequest request) {
		 ModelAndView mv = new ModelAndView();
		if(secretaireService.findByMailSecAndMotdepassSecc(secretaire.getMailSec(), secretaire.getMotdepassSecc())!=null) {

			mv.addObject("mailSec", mailSec);
			   Integer idSec = secretaireRepository.findIdSecByMailSec(mailSec).getIdSec();
			   System.out.println("idSec"+idSec);
			   
			   mv.addObject("idSec", idSec);
			   
			   Integer idMedecin = secretaireRepository.findMedecinIdMedecinByMailSec(mailSec).getMedecin().getIdMedecin();
			   System.out.println("idMedecin"+idMedecin);
			   mv.addObject("idMedecin", idMedecin);
			   
			   
			   String fnameSec = secretaireRepository.findFnameSecByMailSec(mailSec).getFnameSec();
			   System.out.println("fnameSec"+fnameSec);
				mv.addObject("fnameSec", fnameSec);
				 String lnameSec = secretaireRepository.findLnameSecByMailSec(mailSec).getLnameSec();
				   System.out.println("lnameSec"+lnameSec);
					mv.addObject("lnameSec", lnameSec);
					Integer  m = null;
			
					m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
					   mv.addObject("m", m);
	 mv.setViewName("homesecretaire");
			return mv;		}
		else {
			request.setAttribute("error", "Invalid Email or mot de passe");
			request.setAttribute("mode", "MODE_LOGIN");
			 mv.setViewName("loginsec");
		   		return mv;
		
			
		}
	}
	
	
	@RequestMapping("/homesecretaire/{idMedecin}/{idSec}")
	public ModelAndView homesec (@PathVariable("idSec") Integer idSec, @PathVariable("idMedecin") Integer idMedecin, Secretaire secretaire, HttpServletRequest request ) {
		
		ModelAndView mv = new ModelAndView("homesecretaire");
		
		String mailSec = secretaireRepository.findMailSecByIdSec(idSec).getMailSec();
		   System.out.println("mailSec"+mailSec);
			mv.addObject("mailSec", mailSec);

			String motdepassSecc = secretaireRepository.findMailSecByIdSec(idSec).getMotdepassSecc();
			   System.out.println("motdepassSecc"+motdepassSecc);
				mv.addObject("motdepassSecc", motdepassSecc);
				
				
		String fnameSec = secretaireRepository.findFnameSecByMailSec(mailSec).getFnameSec();
		   System.out.println("fnameSec"+fnameSec);
			mv.addObject("fnameSec", fnameSec);
			 String lnameSec = secretaireRepository.findLnameSecByMailSec(mailSec).getLnameSec();
			   System.out.println("lnameSec"+lnameSec);
				mv.addObject("lnameSec", lnameSec);
				
				Integer  m = null;
				m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
				   mv.addObject("m", m);
		return mv;
	}
	
	
	
	
	// liste patient
	@RequestMapping(value="/listpatientsec/{idMedecin}/{idSec}")
	public ModelAndView patient(@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec , Integer idPatient) {
		
		ModelAndView mv = new ModelAndView("listpatientsec");
		
		mv.addObject(medecinRepository.getOne(idMedecin));
		List<Patient> listPatients = patientService.getAllPatients(idMedecin);
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("idPatient", idPatient);
		   mv.addObject("idSec", idSec);
		 
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
	mv.addObject("listPatients", listPatients);
		return mv;
	}
	
	@RequestMapping(value="/afficherpatientsecjsp/{idMedecin}/{idSec}/{idPatient}")
	public ModelAndView patientidmed (@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec ) {
		ModelAndView mv = new ModelAndView("afficherpatientsecjsp");
		
		mv.addObject(medecinRepository.getOne(idMedecin));
		mv.addObject(medecinRepository.getOne(idPatient));
		mv.addObject(medecinRepository.getOne(idSec));
		List<Patient> listPatients = patientService.getPatientbymedandapt(idMedecin, idPatient);
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("idPatient", idPatient);
		  mv.addObject("idSec", idSec);
		  Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
	mv.addObject("listPatients", listPatients);
		return mv;
	}
	@RequestMapping(value="/fiches/{idMedecin}/{idSec}/{idPatient}")
	public ModelAndView fich (@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec ) {
		ModelAndView mv = new ModelAndView("fiches");
		
		mv.addObject(medecinRepository.getOne(idMedecin));
		mv.addObject(medecinRepository.getOne(idPatient));
		mv.addObject(medecinRepository.getOne(idSec));
		List<Patient> listPatients = patientService.getPatientbymedandapt(idMedecin, idPatient);
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("idPatient", idPatient);
		  mv.addObject("idSec", idSec);
		  Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
	mv.addObject("listPatients", listPatients);
		return mv;
	}
	//set mode

	@RequestMapping(value="/ajoutpatsec/{idMedecin}/{idSec}", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ajoutpat(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
		  ModelAndView mv = new ModelAndView("ajoutpatsec");
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idSec", idSec);
		
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
		  
	request.setAttribute("mode", "MODE_REGISTER");
		   
			return mv;
		  

	}
	// ajouter pat

	@RequestMapping(value="/save-patsec/{idMedecin}/{idSec}" , method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView registerPatient( Patient patient,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec,  @RequestParam("cinpat") Integer cinpat, @RequestParam("mailpat") String mailpat, @RequestParam("numtelpat") Integer numtelpat ) {
		
		  ModelAndView mv = new ModelAndView();
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idSec", idSec);
		   if (patientService.findbycin(patient.getCinpat()) == null && patientService.findbymail(patient.getMailpat()) == null && patientService.findbynum(patient.getNumtelpat()) == null ) {
			   
		   patient.setMedecin(new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null));
		   patientService.addPatient(patient);
		request.setAttribute("mode", "MODE_HOME");
		mv.setViewName("patientajoutersec");
		return mv;
		   }
		   else {
				request.setAttribute("error", "invalide cin ou email ou numero de telephone");
				request.setAttribute("mode", "MODE_REGISTER");
				mv.setViewName("ajoutpatsec");

				return mv;

	}
		
	}
	
	//set mode modifier patient

	@RequestMapping(value="/modifierpatsec/{idMedecin}/{idSec}/{idPatient}", method = { RequestMethod.GET, RequestMethod.POST})

	public ModelAndView modifierpat(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec) {
		  ModelAndView mv = new ModelAndView("modifierpatsec");
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idPatient", idPatient);
		   mv.addObject("idSec", idSec);
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
	request.setAttribute("mode", "MODE_REGISTER");
		   
			return mv;
		  

	}

	//ajouter pat

	@RequestMapping(value="/save-pat/{idMedecin}/{idSec}/{idPatient}" , method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView registerPatient( Patient patient, Medecin medecin,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec) {
		
		  ModelAndView mv = new ModelAndView();
		  
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idPatient", idPatient);
		   mv.addObject("idSec", idSec);

		   if (patientService.findbycin(patient.getCinpat()) == null && patientService.findbymail(patient.getMailpat()) == null && patientService.findbynum(patient.getNumtelpat()) == null ) {
			   
		  patient.setMedecin(medecin);
		   patientService.updatePatient(idPatient, patient);
		  
		request.setAttribute("mode", "MODE_HOME");
		mv.setViewName("patmodsec");
		return mv;
		   }
		   else {
				request.setAttribute("error", "invalide cin ou email ou numero de telephone");
				request.setAttribute("mode", "MODE_REGISTER");
				mv.setViewName("modifierpatsec");

				return mv;

	}
		
	}

	// rdv modifier
	@RequestMapping(value="/modifierrdvsec/{idMedecin}/{idSec}/{idPatient}/{idRdv}", method = { RequestMethod.GET, RequestMethod.POST})

	public ModelAndView modifierrdv(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient, @PathVariable("idRdv") Integer idRdv, @PathVariable("idSec") Integer idSec) {
		  ModelAndView mv = new ModelAndView("modifierrdvsec");
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idPatient", idPatient);
		   mv.addObject("idRdv", idRdv);
		   mv.addObject("idSec", idSec);
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
	request.setAttribute("mode", "MODE_REGISTER");
		   
			return mv;
		  

	}
	@RequestMapping(value="/save-rdvm/{idMedecin}/{idSec}/{idPatient}/{idRdv}" , method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modradv( Rdv rdv, Medecin medecin, Patient patient,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient, @PathVariable("idRdv") Integer idRdv, @PathVariable("idSec") Integer idSec, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("dateRdv") Date dateRdv, @RequestParam("timeRdv") Time timeRdv) {
		
		  ModelAndView mv = new ModelAndView();
		  
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idPatient", idPatient);
		   mv.addObject("idRdv", idRdv);
		   mv.addObject("idSec", idSec);

		   if (rdvService.getrdvbybyby(idMedecin, dateRdv, timeRdv) == null) {
			   
		   rdvService.updaterdv(idRdv, rdv);
		  
		request.setAttribute("mode", "MODE_HOME");
		mv.setViewName("rdvmodifiersec");
		return mv;
		   }
		   else {
				request.setAttribute("error", "rendez vous deja réservé");
				request.setAttribute("mode", "MODE_REGISTER");
				mv.setViewName("modifierrdvsec");

				return mv;

	}
		
	}
	@RequestMapping("/patientajoutersec/{idMedecin}/{idSec}")
	public ModelAndView ajo (@PathVariable("idSec") Integer idSec, @PathVariable("idMedecin") Integer idMedecin, Secretaire secretaire, HttpServletRequest request ) {
		
		ModelAndView mv = new ModelAndView("homesecretaire");
		
		String mailSec = secretaireRepository.findMailSecByIdSec(idSec).getMailSec();
		   System.out.println("mailSec"+mailSec);
			mv.addObject("mailSec", mailSec);

			String motdepassSecc = secretaireRepository.findMailSecByIdSec(idSec).getMotdepassSecc();
			   System.out.println("motdepassSecc"+motdepassSecc);
				mv.addObject("motdepassSecc", motdepassSecc);
				
				
		String fnameSec = secretaireRepository.findFnameSecByMailSec(mailSec).getFnameSec();
		   System.out.println("fnameSec"+fnameSec);
			mv.addObject("fnameSec", fnameSec);
			 String lnameSec = secretaireRepository.findLnameSecByMailSec(mailSec).getLnameSec();
			   System.out.println("lnameSec"+lnameSec);
				mv.addObject("lnameSec", lnameSec);
		return mv;
	}
	
	//set mode rdv 

	@RequestMapping(value="/ajouterrdvsec/{idMedecin}/{idSec}/{idPatient}", method = { RequestMethod.GET, RequestMethod.POST})

	public ModelAndView ajoutrdv(HttpServletRequest request, @PathVariable("idSec") Integer idSec,  @PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient) {
		  ModelAndView mv = new ModelAndView("ajouterrdvsec");
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idPatient", idPatient);
		   mv.addObject("idSec", idSec);
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
	request.setAttribute("mode", "MODE_REGISTER");
		 return mv;
		  

	}

	//ajouter rdv

	@RequestMapping(value="/save-rdv/{idMedecin}/{idSec}/{idPatient}" , method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView registerRdv( Rdv rdv,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("dateRdv") Date dateRdv, @RequestParam("timeRdv") Time timeRdv) {
		
		  ModelAndView mv = new ModelAndView();
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idPatient", idPatient);
		   mv.addObject("idSec", idSec);
		   if(rdvService.getrdvbybyby(idMedecin, dateRdv, timeRdv) == null) {
		   rdv.setMedecin(new Medecin(idMedecin, "", "", "", null, "", "", "", "", "", null));
	       rdv.setPatient(new Patient(idPatient, null, "", "", "", null, "", null, "", null, "", "", "", "", null, "", idMedecin));
	        rdvService.addRdv(rdv);
		request.setAttribute("mode", "MODE_HOME");
		mv.setViewName("rdvajoutersec");
		return mv;
		
		   }	 else {
				request.setAttribute("error", "rendez vous deja réservé");
				request.setAttribute("mode", "MODE_REGISTER");
				mv.setViewName("ajouterrdvsec");
				return mv;
			}
	}
	@RequestMapping(value="/supprimerpat/{idMedecin}/{idSec}/{idPatient}" , method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView supppat( Patient patient,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec) {
		
		  ModelAndView mv = new ModelAndView("patientsuppsec");
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idPatient", idPatient);
		   mv.addObject("idSec", idSec);

	patientService.delete(idPatient);

		return mv;
		
		
	}
	@RequestMapping(value="/listrdvsec/{idMedecin}/{idSec}")
	public ModelAndView rdv(@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
		ModelAndView mv = new ModelAndView("listrdvsec");
		mv.addObject(medecinRepository.getOne(idMedecin));
		List<Rdv> listRdvs = rdvService.getAllRdvsda(idMedecin);
		
		  mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idSec", idSec);
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
		mv.addObject("listRdvs", listRdvs);
		return mv;
	}
	@RequestMapping(value="/listrdvsectoday/{idMedecin}/{idSec}")
	public ModelAndView rdvtoo(@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
		ModelAndView mv = new ModelAndView("listrdvsectoday");
		mv.addObject(medecinRepository.getOne(idMedecin));
		List<Rdv> listRdvs = rdvService.getAllRdvs(idMedecin);
		
		  mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idSec", idSec);
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
		mv.addObject("listRdvs", listRdvs);
		return mv;
	}
	@RequestMapping(value="/listconsultationsec/{idMedecin}/{idSec}")
	public ModelAndView consultation(@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
		ModelAndView mv = new ModelAndView("listconsultationsec");
		mv.addObject(medecinRepository.getOne(idMedecin));

	   List<Consultation> listConsultations = consultationService.getAllConsultations(idMedecin);
		  mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idSec", idSec);
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
		mv.addObject("listConsultations", listConsultations);
		return mv;
	}
	
	@RequestMapping(value="/afficherconssec/{idMedecin}/{idSec}/{idRdv}/{idPatient}/{idCons}")
	public ModelAndView afficherconsultation(@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons, @PathVariable("idSec") Integer idSec) {
		ModelAndView mv = new ModelAndView("afficherconssec");
		mv.addObject(medecinRepository.getOne(idMedecin));
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("idRdv", idRdv);
		  mv.addObject("idPatient", idPatient);
		  mv.addObject("idCons", idCons);
		   mv.addObject("idSec", idSec);

	   List<Consultation> listConsultations = consultationService.getConsultation(idCons);
		
		mv.addObject("listConsultations", listConsultations);
		return mv;
	}
	//set mode cert

	@RequestMapping(value="/affichercert/{idMedecin}/{idSec}/{idRdv}/{idPatient}/{idCons}", method = { RequestMethod.GET, RequestMethod.POST})

	public ModelAndView ajoutcer(HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons, @PathVariable("idSec") Integer idSec) {
		  ModelAndView mv = new ModelAndView("affichercert");
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("idRdv", idRdv);
		  mv.addObject("idPatient", idPatient);
		  mv.addObject("idCons", idCons);
		   mv.addObject("idSec", idSec);

			if(certificatRepository.findByConsultationIdCons(idCons)  == null) {
	request.setAttribute("mode", "MODE_REGISTER");
	mv.setViewName("affichercert");
		 return mv;
			}
			 else {
				Integer idCertificat = null;
				   List<Certificat> listCertificats = certificatService.getcert(idCons, idCertificat);
				   mv.addObject("listCertificats", listCertificats);
			 return mv;
			  }
			

	}


		
	@RequestMapping(value="/afficherord/{idMedecin}/{idSec}/{idRdv}/{idPatient}/{idCons}", method = { RequestMethod.GET, RequestMethod.POST})

	public ModelAndView ajoutord(HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idRdv") Integer idRdv, @PathVariable("idPatient") Integer idPatient, @PathVariable("idCons") Integer idCons, @PathVariable("idSec") Integer idSec) {
		  ModelAndView mv = new ModelAndView("afficherord");
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("idRdv", idRdv);
		  mv.addObject("idPatient", idPatient);
		  mv.addObject("idCons", idCons);
		   mv.addObject("idSec", idSec);

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

	@RequestMapping(value="/supprimerrdvsec/{idMedecin}/{idSec}/{idRdv}" , method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView supprdv( Rdv rdv,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin,  @PathVariable("idRdv") Integer idRdv, @PathVariable("idSec") Integer idSec) {
		
		  ModelAndView mv = new ModelAndView("rdvsupprimersec");
		   mv.addObject("idMedecin", idMedecin);
		   mv.addObject("idRdv", idRdv);
		   mv.addObject("idSec", idSec);

	rdvService.delete(idRdv);

		return mv;
		
		
	}
	@RequestMapping(value="/listmsgrecu/{idMedecin}/{idSec}")
	public ModelAndView msgenvoi(@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
		ModelAndView mv = new ModelAndView("listmsgrecu");
		List<Message> listMsgs = messageService.getAllmsgsec(idSec);
		  mv.addObject("idPatient", idSec);
		   mv.addObject("idMedecin", idMedecin);
		Integer  m = null;
	m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
	   mv.addObject("m", m);

mv.addObject("listMsgs", listMsgs);
		return mv;
	}
	
	
	
	
	// msg
	@RequestMapping(value="/envoimsgapat/{idMedecin}/{idSec}/{idPatient}/{idmsg}", method = { RequestMethod.GET, RequestMethod.POST})

	public ModelAndView msgpat(Message message, HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec, @PathVariable("idmsg") Integer idmsg) {
		  ModelAndView mv = new ModelAndView("envoimsgapat");
		   mv.addObject("idPatient", idPatient);
		   mv.addObject("idSec", idSec);
		   mv.addObject("idMedecin", idMedecin);
		   String obj = null;
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
messageService.change(message, idmsg, obj);
			
	
List<Message> listMsgs = messageService.getAllmsgsecpat(idmsg);
		   mv.addObject("listMsgs", listMsgs);

	request.setAttribute("mode", "MODE_REGISTER");
			return mv;
		  

	}
	@RequestMapping(value="/save-msgsec/{idMedecin}/{idSec}/{idPatient}" , method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView msgsect(Messagesec messagesec,  BindingResult bindingResult, HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idPatient") Integer idPatient, @PathVariable("idSec") Integer idSec) {
		
		  ModelAndView mv = new ModelAndView("msgenvoyer");
		  mv.addObject("idPatient", idPatient);
		   mv.addObject("idSec", idSec);
		   mv.addObject("idMedecin", idMedecin);
	
	 messagesec.setSecretaire(new Secretaire(idSec, "", "", "", null, "", "", "", idMedecin));
	 messagesec.setPatient(new Patient(idPatient, null, "", "", "", null, "", null, "", null, "", "", "", "", null, "",idMedecin));
	  messagesec.setVus("non");

	 messagesecService.addMsgsec(messagesec);
		 
		   request.setAttribute("mode", "MODE_HOME");
			return mv;

	}
	@RequestMapping(value="/listmsgenvoisec/{idMedecin}/{idSec}")
	public ModelAndView msgen(@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
		ModelAndView mv = new ModelAndView("listmsgenvoisec");
		
		
		List<Messagesec> listMsgs = messagesecService.getAllmsgsecsec(idSec);
		  
		  mv.addObject("idSec", idSec);
		   mv.addObject("idMedecin", idMedecin);
		   Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
	mv.addObject("listMsgs", listMsgs);
		return mv;
	}
	@RequestMapping(value="/list/{idMedecin}/{idSec}", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView recherchrrdv(Rdv rdv, @PathVariable("idMedecin") Integer idMedecin,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("dateRdv") Date dateRdv,@PathVariable("idSec") Integer idSec, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("result2");
		mv.addObject(medecinRepository.getOne(idMedecin));
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("dateRdv", dateRdv);
		  mv.addObject("idSec", idSec);
		  Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
		List<Rdv> listRdvs = rdvService.recherche(idMedecin, dateRdv);
		mv.addObject("listRdvs", listRdvs);
		return mv;
	}
	@RequestMapping(value="/listpat/{idMedecin}/{idSec}", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView recherchrrdv(Patient patient, @PathVariable("idMedecin") Integer idMedecin, @RequestParam("lnamepat") String lnamepat,@PathVariable("idSec") Integer idSec, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("resultpats");
		mv.addObject(medecinRepository.getOne(idMedecin));
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("lnamepat", lnamepat);
		  mv.addObject("idSec", idSec);
		  Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
		List<Patient> listPatients = patientService.getrcherche(idMedecin, lnamepat);
		mv.addObject("listPatients", listPatients);
		return mv;
	}
	@RequestMapping(value="/listpati/{idMedecin}/{idSec}", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView recherchrpat(Patient patient, @PathVariable("idMedecin") Integer idMedecin, @RequestParam("cinpat") Integer cinpat,@PathVariable("idSec") Integer idSec, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("resultpats");
		mv.addObject(medecinRepository.getOne(idMedecin));
		  mv.addObject("idMedecin", idMedecin);
		  mv.addObject("cinpat", cinpat);
		  mv.addObject("idSec", idSec);
		  Integer  m = null;
			m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
			   mv.addObject("m", m);
		List<Patient> listPatients = patientService.getrcherchecin(idMedecin, cinpat);
		mv.addObject("listPatients", listPatients);
		return mv;
	}
///// chatt 
@RequestMapping(value="/chatsec/{idMedecin}/{idSec}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView chatsec(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
	  ModelAndView mv = new ModelAndView("chatsec");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idSec", idSec);
	   //liste msg
	   Integer  m = null;
		m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
		   mv.addObject("m", m);
	   List<Chat> listChat = chatService.getall(idSec, idMedecin);
	   mv.addObject("listChat", listChat);

	   
		return mv;
	  

}
///// chaatttt 
@RequestMapping(value="/save-chatsec/{idMedecin}/{idSec}", method = {RequestMethod.POST} )
public ModelAndView envoisec(Chat chat,  BindingResult bindingResult, HttpServletRequest request,@PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
	ModelAndView mv = new ModelAndView();
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idSec", idSec);
	 chat.setMedecin(new Medecin (idMedecin, "", "", "", null, "", "", "", "", "", null));
	   chat.setSecretaire(new Secretaire(idSec, "", "", "", null, "", "", "", idMedecin));
	   chat.setRole("secretaire"); 
	
	   chatRepository.saveAndFlush(chat);
	   mv.setViewName("chatsec");
	   //liste msg
	   List<Chat> listChat = chatService.getall(idSec, idMedecin);
	   mv.addObject("listChat", listChat);
	   Integer  m = null;
		m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
		   mv.addObject("m", m);
	return mv;
}
@RequestMapping(value="/chatmsg/{idMedecin}/{idSec}", method = { RequestMethod.GET, RequestMethod.POST})

public ModelAndView chatsecmsg(HttpServletRequest request, @PathVariable("idMedecin") Integer idMedecin, @PathVariable("idSec") Integer idSec) {
	  ModelAndView mv = new ModelAndView("chatmsg");
	   mv.addObject("idMedecin", idMedecin);
	   mv.addObject("idSec", idSec);
	   //liste msg
	   List<Chat> listChat = chatService.getall(idSec, idMedecin);
	   mv.addObject("listChat", listChat);

	   Integer  m = null;
		m =	 messageRepository.countByVuAndSecretaireIdSec("non", idSec);
		   mv.addObject("m", m);
		return mv;
	  

}
}

	
	



