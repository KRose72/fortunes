package com.grangeinsurance.fortunes;

import java.util.Map;

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

	public void setFortunes(Map<Integer, String> fortunes) {
		this.fortunes = fortunes;
	}
	
}
