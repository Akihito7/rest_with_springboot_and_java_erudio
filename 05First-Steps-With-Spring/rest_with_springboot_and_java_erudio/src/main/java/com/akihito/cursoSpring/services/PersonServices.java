package com.akihito.cursoSpring.services;

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
		person.setGenre("Male");
		
		return person;
	}
	
    
   
}
