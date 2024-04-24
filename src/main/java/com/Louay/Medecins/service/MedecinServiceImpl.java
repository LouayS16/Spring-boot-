package com.Louay.Medecins.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Louay.Medecins.entities.Medecin;
import com.Louay.Medecins.repos.MedecinRepository;

@Service
public class MedecinServiceImpl implements MedecinService {
	@Autowired
	MedecinRepository MedecinRepository;

	@Override
	public Medecin saveMedecin(Medecin m) {
		return MedecinRepository.save(m);
	}

	@Override
	public Medecin updateMedecin(Medecin m) {
		return MedecinRepository.save(m);
	}

	@Override
	public void deleteMedecin(Medecin m) {
		MedecinRepository.delete(m);
	}

	@Override
	public void deleteMedecinById(Long id) {
		MedecinRepository.deleteById(id);
	}

	@Override
	public Medecin getMedecin(Long id) {
		return MedecinRepository.findById(id).get();
	}

	@Override
	public List<Medecin> getAllMedecins() {
		return MedecinRepository.findAll();
	}

	@Override
	public Page<Medecin> getAllMedecinsParPage(int page, int size) {
		return MedecinRepository.findAll(PageRequest.of(page, size));
	}
}
