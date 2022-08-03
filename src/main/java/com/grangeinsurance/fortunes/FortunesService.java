package com.grangeinsurance.fortunes;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class FortunesService {
	
	private FortunesList fortuneList;
	private Random random;
	
	public FortunesService(FortunesList fortuneList) throws NoSuchAlgorithmException { 
		this.fortuneList = fortuneList;	
		random = SecureRandom.getInstanceStrong();
	}

	public Map<Integer, String> fortunes() {
		return fortuneList.getFortunes();
	}

	public Map<Integer, String> getFortune(int id) {
		Map<Integer, String> result = new HashMap<>();
		Integer max = fortuneList.getFortuneListSize();
		
		if (id < 1 || id > max) throw new FortuneNotFoundException("Fortune not found for the ID: " + id);
		result.put(id, fortuneList.getFortuneByID(id));
		return result;
		
//		if (id > 0 && id <= max) {
//			result.put(id, fortuneList.getFortuneByID(id));
//			return result;
//		} else {
//			result.put(id, "Please enter a valid ID value.");
//			return result;
//		}
	
	}

	public Map<Integer, String> getRandomFortune() {
		Map<Integer, String> result = new HashMap<>();
		Integer id;
		Integer max = fortuneList.getFortuneListSize();
		
		random.setSeed(System.currentTimeMillis());
		id = random.nextInt(max) + 1;
		
		result.put(id, fortuneList.getFortuneByID(id));
		
		return result;
	}

}
