package com.grangeinsurance.fortunes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class FortunesService {
	
	private FortunesList fortuneList;
	
	public FortunesService(FortunesList fortuneList) { this.fortuneList = fortuneList;	}

	public Map<Integer, String> fortunes() {
		return fortuneList.getFortunes();
	}

	public Map<Integer, String> getFortune(int id) {
		Map<Integer, String> result = new HashMap<>();
		Integer max = fortuneList.getFortuneListSize();
		if (id > 0 && id <= max) {
			result.put(id, fortuneList.getFortuneByID(id));
			return result;
		} else {
			result.put(id, "Please enter a valid ID value.");
			return result;
		}
	
	}

	public Map<Integer, String> getRandomFortune() {
		Map<Integer, String> result = new HashMap<>();
		Integer id;
		Integer max = fortuneList.getFortuneListSize();
		Random random = new Random();
		
		id = random.nextInt(max) + 1;
		result.put(id, fortuneList.getFortuneByID(id));
		
		return result;
	}

}
