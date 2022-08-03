package com.grangeinsurance.fortunes;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortunesController {
	
	private FortunesService service;
	
	public FortunesController(FortunesService service) { this.service= service;	}
	
	@GetMapping("/fortunes")
	public Map<Integer, String> fortunes() {
		return service.fortunes();
	}
	
	@GetMapping("/fortunes/{id}")
	public Map<Integer, String> getFortune(@PathVariable("id")Integer id) {
		
		return service.getFortune(id);
	}

	@GetMapping("/fortunes/random")
	public Map<Integer, String> getRandomFortune() {
		return service.getRandomFortune();
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleFortuneNotFoundException(FortuneNotFoundException ex) {
		ErrorObject errorOb = new ErrorObject(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(errorOb, HttpStatus.NOT_FOUND);
	}
}
