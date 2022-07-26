package com.grangeinsurance.fortunes;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
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
}
