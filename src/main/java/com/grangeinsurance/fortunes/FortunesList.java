package com.grangeinsurance.fortunes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties
public class FortunesList {
	
	private Map<Integer, String> fortunes;

	public Map<Integer, String> getFortunes() {
		return fortunes;
	}
	
	public String getFortuneByID(Integer id) {
		if (id > 0 && id <= fortunes.size()) {
			return fortunes.get(id);
		} else {
			return "Please enter a valid ID value.";
		}
	}
	
	public Integer getFortuneListSize() {
		return fortunes.size();
	}

	public void setFortunes(Map<Integer, String> fortunes) {
		this.fortunes = fortunes;
	}

	public Map<Integer, String> getRandomFortune() {
		Map<Integer, String> result = new HashMap<>();
		Integer id;
		Integer max = fortunes.size();
		Random random = new Random();
		
		id = random.nextInt(max) + 1;
		
		result.put(id, fortunes.get(id));
		return result;
	}
	
}
