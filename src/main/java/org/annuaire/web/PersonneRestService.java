package org.annuaire.web;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.annuaire.dao.PersonneRepository;
import org.annuaire.entities.Personne;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PersonneRestService  {
	@Autowired
	PersonneRepository personneRepository;
	@GetMapping(value="/personnes")
	public List<Personne> getPers(){
		return personneRepository.findAll();
	}
	@GetMapping(value="/personnes/{id}")
    public Optional<Personne> getPers(@PathVariable  long id){
	  return personneRepository.findById(id);
  }
	@GetMapping(value="/personnes/bureau")
	public Personne getPerso(@RequestParam(name="mc",defaultValue="") String mc){
		return personneRepository.findByBureau(mc);
	}
	@GetMapping(value="/bureaux/{nom}")
	public Personne getBur(@PathVariable String nom){
		return personneRepository.findPersonneByNom(nom);
	} 
	@RequestMapping(value="/personnes",method=RequestMethod.POST)
    public Personne ajoutPers(@RequestBody Personne p) {
	  return personneRepository.save(p);
  }
	@RequestMapping(value="/personnes/{nom}",method=RequestMethod.PUT)
    public Personne updaPers(@PathVariable String nom,@RequestBody Personne p) {
		p.setNom(nom);;
	  return personneRepository.save(p);
  }
	@RequestMapping(value="/personnes/{nom}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable String nom) {
		personneRepository.deleteById(personneRepository.findPersonneByNom(nom).getId());
		return true;
	}
	



}
