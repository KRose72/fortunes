package com.grangeinsurance.fortunes;

import java.util.HashMap;
import java.util.Map;

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

	public Map<Integer, String> fortunes() {
		return fortuneList.getFortunes();
	}

	public Map<Integer, String> getFortune(int id) {
		Map<Integer, String> result = new HashMap<>();
		result.put(id, fortuneList.getFortuneByID(id));
		return result;
	}

	public Map<Integer, String> getRandomFortune() {
		return fortuneList.getRandomFortune();
	}

}
