package com.Louay.Medecins;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.Louay.Medecins.entities.Medecin;
import com.Louay.Medecins.repos.MedecinRepository;
import com.Louay.Medecins.service.MedecinService;

@SpringBootTest
class MedecinsApplicationTests {
	@Autowired
	private MedecinRepository MedecinRepository;
	private MedecinService MedecinService;

	@Test
	public void testCreateMedecin() {
		Medecin med = new Medecin("Saad", "Wided", "Cardiologie", 30000.0, 98799212);
		MedecinRepository.save(med);
	}

	@Test
	public void testFindMedecin() {
		Medecin m = MedecinRepository.findById(2L).get();
		System.out.println(m);
	}

	@Test
	public void testUpdateMedecin() {
		Medecin m = MedecinRepository.findById(2L).get();
		m.setSalaire(45000.0);
		MedecinRepository.save(m);
	}

	@Test
	public void testDeleteMedecin() {
		MedecinRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousMedecins() {
		List<Medecin> meds = MedecinRepository.findAll();
		for (Medecin m : meds) {
			System.out.println(m);
		}
	}

	@Test
	public void testFindByNomMedecinContains() {
		Page<Medecin> meds = MedecinService.getAllMedecinsParPage(0, 2);
		System.out.println(meds.getSize());
		System.out.println(meds.getTotalElements());
		System.out.println(meds.getTotalPages());
		meds.getContent().forEach(m -> {
			System.out.println(m.toString());
		});
		/*
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 */
	}
}