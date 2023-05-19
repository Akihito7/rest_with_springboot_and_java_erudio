package com.akihito.cursoSpring.services;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.akihito.cursoSpring.model.PersonEntity;

@Service
public class PersonServices {
	
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public PersonEntity findByid(String id) {
		
		logger.info("finding a peson");
		
		PersonEntity person = new PersonEntity();
		
		person.setId(counter.getAndIncrement());
		person.setFirstName("Guilherme");
		person.setLastName("Iha");
		person.setAdrres("São vicente - São Paulo - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
	public ArrayList<PersonEntity> findByAll(){
		
		ArrayList<PersonEntity> peoples = new ArrayList<>();
		
	    for (int i = 0; i < 8; i++) {
	    	PersonEntity person = mockPerson(i);
	    	peoples.add(person);
	    }
		
		return peoples;
		
		
	}
	
	public PersonEntity mockPerson(int id) {
		
		PersonEntity person = new PersonEntity();
		
		person.setId(counter.getAndIncrement());
		person.setFirstName("first name " + id);
		person.setLastName("last name " + id);
		person.setAdrres("addres " + id);
		person.setGender("Gender " + id);
		
		return person;
		
	}
	
	public PersonEntity create(PersonEntity person) {
		
		/* aqui seria onde iriamos receber o objeto person, e iriamos conectar
		 * com o banco de dados cadastrando o novo usuario
		 * */
		logger.info("creating a peson");
		
		person.setId(counter.getAndIncrement());
	
		PersonEntity personX = new PersonEntity();
		personX.setFirstName(person.getFirstName());
		personX.setLastName(person.getLastName());
		personX.setAdrres(person.getAdrres());
		personX.setGender(person.getGender());
		
		
	   return personX;
	}
	
	public PersonEntity update(PersonEntity person) {
		
		logger.info("updating a peson");
		
		return person;
	}
	
	public void delete(String id) {
		
		logger.info("deleting a peson");
		
	}
	
    
   
}
