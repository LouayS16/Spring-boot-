package com.Louay.Medecins.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Louay.Medecins.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
