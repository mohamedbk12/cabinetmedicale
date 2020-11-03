package com.cabinet.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cabinet.demo.entity.Patient;
import com.cabinet.demo.services.PatientService;

@Controller
public class MainController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping("index")
	public String hello() {
		return "index";
		
	}
	
	
	
	// @RequestMapping("//{idMedecin}")
	
	//public String home (Model model, @PathVariable("idMedecin") Integer idMedecin)
	//{
  //List<Patient> listPatients = new ArrayList<Patient>();
 
//listPatients= patientService.getAllPatients(idMedecin);

//model.addAttribute("listPatients", listPatients);
	//	return "index";
		//}
	 
	 
	 
	    
}
