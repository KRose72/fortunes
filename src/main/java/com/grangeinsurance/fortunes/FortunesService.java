package com.grangeinsurance.fortunes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FortunesService {
	
	private FortunesList fortuneList;
	
	public FortunesService(FortunesList fortuneList) { this.fortuneList = fortuneList;	}
	
	@Value("${works}")
	private String works;
	
	public String testMethod() {
		System.out.println(fortuneList.getFortunes());
		return works;
	}
}
