package com.Louay.Medecins.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Louay.Medecins.entities.Medecin;

public interface MedecinService {
	Medecin saveMedecin(Medecin m);

	Medecin updateMedecin(Medecin m);

	void deleteMedecin(Medecin m);

	void deleteMedecinById(Long id);

	Medecin getMedecin(Long id);

	List<Medecin> getAllMedecins();

	Page<Medecin> getAllMedecinsParPage(int page, int size);
}