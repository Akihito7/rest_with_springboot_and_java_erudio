package com.akihito.cursoSpring;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	private static final String template = "Hello %s!";
	private final AtomicLong Counter =  new AtomicLong();
	
	
	@RequestMapping(method=RequestMethod.GET)
	public Greeting greeting
	(@RequestParam(value = "name", defaultValue = "Cristiano Ronaldo") String name) {
		
		return new Greeting(Counter.getAndIncrement(),String.format(template, name));
	}

}
