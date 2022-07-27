package com.grangeinsurance.fortunes;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortunesController {
	
	private FortunesService service;
	
	public FortunesController(FortunesService service) { this.service= service;	}
	
	@GetMapping("/test")
	public String testMethod() {
		return service.testMethod();
	}
	
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
}
