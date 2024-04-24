package com.Louay.Medecins.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.Louay.Medecins.entities.Medecin;
import com.Louay.Medecins.service.MedecinService;

@Controller
public class MedecinController {
	@RequestMapping("/myView")
	public String myView() {
		return "myView";
	}

	@Autowired
	MedecinService MedecinService;

	@RequestMapping("/ListeMedecins")
	public String listeMedecins(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Medecin> meds = MedecinService.getAllMedecinsParPage(page, size);
		modelMap.addAttribute("Medecins", meds);
		modelMap.addAttribute("pages", new int[meds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeMedecins";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createMedecin";
	}

	@RequestMapping("/saveMedecin")
	public String saveMedecin(@ModelAttribute("Medecin") Medecin Medecin, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {

		Medecin saveMedecin = MedecinService.saveMedecin(Medecin);
		String msg = "Medecin enregistré avec Id " + saveMedecin.getIdMedecin();
		modelMap.addAttribute("msg", msg);
		return "createMedecin";
	}

	@RequestMapping("/supprimerMedecin")
	public String supprimerMedecin(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		MedecinService.deleteMedecinById(id);
		Page<Medecin> meds = MedecinService.getAllMedecinsParPage(page, size);
		modelMap.addAttribute("Medecins", meds);
		modelMap.addAttribute("pages", new int[meds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeMedecins";
	}

	@RequestMapping("/modifierMedecin")
	public String editerMedecin(@RequestParam("id") Long id, ModelMap modelMap) {
		Medecin m = MedecinService.getMedecin(id);
		modelMap.addAttribute("Medecin", m);
		return "editerMedecin";
	}

	@RequestMapping("/updateMedecin")
	public String updateMedecin(@ModelAttribute("Medecin") Medecin Medecin, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {

		MedecinService.updateMedecin(Medecin);
		List<Medecin> meds = MedecinService.getAllMedecins();
		modelMap.addAttribute("Medecins", meds);
		return "listeMedecins";
	}

}