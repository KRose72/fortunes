package com.grangeinsurance.fortunes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortunesController {

	@Value("${works}")
	private String works;
	
	@GetMapping("/test")
	public String testMethod() {
		return works;
	}
}
