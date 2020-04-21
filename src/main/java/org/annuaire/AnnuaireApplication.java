package org.annuaire;

import org.annuaire.dao.PersonneRepository;
import org.annuaire.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnuaireApplication implements CommandLineRunner {
	@Autowired
	private PersonneRepository personneRepository;
	public static void main(String[] args) {
		SpringApplication.run(AnnuaireApplication.class, args);
	}

	public void run(String... args) throws Exception {
		personneRepository.save(new Personne("fakir", "bureau1"));
		personneRepository.save(new Personne("idrissi", "bureau2"));
		personneRepository.save(new Personne("adam", "bureau3"));
		for(Personne p:  personneRepository.findAll())
		       System.out.println(p.getNom());

		
	}

}
