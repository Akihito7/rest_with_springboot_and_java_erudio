package com.akihito.cursoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akihito.cursoSpring.model.PersonEntity;
import com.akihito.cursoSpring.services.PersonServices;

@RestController
@RequestMapping(value = "/person")

public class PersonController {
	
	
	@Autowired // private PersonServices person = new PersonServices(); ele vai instanciar a classe em tempo de execução!
	
	private PersonServices person;
	
	@RequestMapping
	(
	 value = "/{id}",
	 method=RequestMethod.GET,
     produces = MediaType.APPLICATION_JSON_VALUE
     )
	public PersonEntity findById(@PathVariable(value = "id") String id) throws Exception {
		
		return person.findByid(id);
		
	}
	

	
	
}
