package com.grangeinsurance.fortunes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FortunesService {
	
	@Value("${works}")
	private String works;
	
	public String testMethod() {
		return works;
	}
}
