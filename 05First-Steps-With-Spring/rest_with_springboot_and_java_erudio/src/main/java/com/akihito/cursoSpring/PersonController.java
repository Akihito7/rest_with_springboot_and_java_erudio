package com.akihito.cursoSpring;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping
	(
	  value = "",
	  method= RequestMethod.GET,
	  produces = MediaType.APPLICATION_JSON_VALUE
			
	)
	public ArrayList<PersonEntity> findByAll(){
		
		return person.findByAll();
	}
	
	@RequestMapping
	(
		value = "",
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
			
	)
	public PersonEntity create(@RequestBody PersonEntity personX) {
		
		return person.create(personX);
	}
	
	@RequestMapping
	(
		value = "",
		method = RequestMethod.PUT,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
     )
	public PersonEntity update(@RequestBody PersonEntity personX) {
		
		return person.update(personX);
		
	}
	
	@RequestMapping
	(
	  value = "/{id}",
	  method = RequestMethod.DELETE
	)
	public String delete(@PathVariable(value = "id")String id) {
		
		person.delete(id);
		
		return "successfully deleted";
		
	}
	

	
	
}
