package com.Louay.Medecins;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Louay.Medecins.entities.Medecin;
import com.Louay.Medecins.service.MedecinService;
@SpringBootApplication
public class MedecinsApplication implements CommandLineRunner {
@Autowired
MedecinService MedecinService;
public static void main(String[] args) {
SpringApplication.run(MedecinsApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
MedecinService.saveMedecin(new Medecin("Kilani","Karim","Rhumatologie",35000.0,99877645 ));
MedecinService.saveMedecin(new Medecin("Tounsi","Hakim", "Rhumatologie",3800.0, 56788945));
MedecinService.saveMedecin(new Medecin("Abdjlil","Fatma", "Médecine d’urgence",1900.0, 52544632));
}
}