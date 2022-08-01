package com.grangeinsurance.fortunes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FortunesServiceTest {
	
	@Mock FortunesList mockService;
	
	private FortunesService subject;
	
	@BeforeEach
	void setup() {
		subject = new FortunesService(mockService);
	}
	
	@Test
	void serviceReturnsFullListOfFortunes() {
		
		final HashMap<Integer, String> expected = new HashMap<Integer, String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -7472342844707953360L;

			{
	    		put(1, "A dubious friend may be an enemy in camouflage.");
	    		put(2, "A person of words and not deeds is like a garden full of weeds.");
	    		put(3, "A smile is your personal welcome mat.");
	    		put(4, "Believe in yourself and others will too.");
	    		put(5, "Carve your name on your heart and not on marble.");
	    		put(6, "Curiosity kills boredom. Nothing can kill curiosity.");
	    		put(7, "Distance yourself from the vain.");
	    		put(8, "Don’t let the past and useless detail choke your existence.");
	    		put(9, "Everyday in your life is a special occasion.");
	    		put(10, "It is worth reviewing some old lessons.");
	    		put(11, "Listen not to vain words of empty tongue.");
	    		put(12, "Nothing is more difficult, and therefore more precious, than to be able to decide.");
	    		put(13, "Now is a good time to buy stock.");
	    		put(14, "Perhaps you’ve been focusing too much on saving.");
	    		put(15, "Any day above ground is a good day.");
	    		put(16, "Could I get some directions to your heart?");
	    		put(17, "Stand tall. Don’t look down upon yourself.");
	    		put(18, "Success is failure turned inside out.");
	    		put(19, "The best prediction of future is the past.");
	    		put(20, "The only people who never fail are those who never try.");
	    		put(21, "The small courtesies sweeten life, the greater ennoble it.");
	    		put(22, "The value lies not within any particular thing, but in the desire placed on that thing.");
	    		put(23, "The weather is wonderful.");
	    		put(24, "There’s no such thing as an ordinary cat.");
	    		put(25, "Things don’t just happen; they happen just.");
	    		put(26, "What’s yours in mine, and what’s mine is mine.");
	    		put(27, "With age comes wisdom.");
	    		put(28, "You are busy, but you are happy.");
	    		put(29, "You are interested in higher education, whether material or spiritual.");
	    		put(30, "You can see a lot just by looking.");
	    		put(31, "You have a friendly heart and are well admired.");
	    		put(32, "You love chinese food.");
	    		put(33, "You never hesitate to tackle the most difficult problems.");
	    		put(34, "You only treasure what you lost.");
	    		put(35, "You should pay for this check. Be generous.");
	    		put(36, "You will have a fine capacity for the enjoyment of life.");
	    		put(37, "You will soon be surrounded by good friends and laughter.");
	    		put(38, "Your infinite capacity for patience will be rewarded sooner or later.");
	    		put(39, "Your quick wits will get you out of a tough situation.");
	    		put(40, "Your work interests can capture the highest status or prestige.");
	    	}
	    };
	    
	    when(mockService.getFortunes()).thenReturn(expected);
	    Map<Integer, String> response = subject.fortunes();
	    assertThat(response).isEqualTo(expected);
	}
	
	@Test
	void serviceReturnsKeyValuePairWhenAKeyIsRecieved() {
		
		final HashMap<Integer, String> expected = new HashMap<Integer, String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -7472342844707953360L;

			{
	    
	    		put(14, "Perhaps you’ve been focusing too much on saving.");
	    		
	    	}
	    };
	    
	    when(mockService.getFortuneByID(14)).thenReturn("Perhaps you’ve been focusing too much on saving.");
	    when(mockService.getFortuneListSize()).thenReturn(40);
	    Map<Integer, String> response = subject.getFortune(14);
	    assertThat(response).isEqualTo(expected);
	}
	
	@Test
	void serviceReturnsPromptMessageWhenKeyFortyTwoIsOutOfBounds() {
		
		final HashMap<Integer, String> expected = new HashMap<Integer, String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -7472342844707953360L;

			{
	    
	    		put(42, "Please enter a valid ID value.");
	    		
	    	}
	    };
	    
	    when(mockService.getFortuneListSize()).thenReturn(40);
	    Map<Integer, String> response = subject.getFortune(42);
	    assertThat(response).isEqualTo(expected);
	}
	
	@Test
	void serviceReturnsPromptMessageWhenKeyZeroIsOutOfBounds() {
		
		final HashMap<Integer, String> expected = new HashMap<Integer, String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -7472342844707953360L;

			{
	    
	    		put(0, "Please enter a valid ID value.");
	    		
	    	}
	    };
	    
	    when(mockService.getFortuneListSize()).thenReturn(40);
	    Map<Integer, String> response = subject.getFortune(0);
	    assertThat(response).isEqualTo(expected);
	}
	
	@Test
	void serviceReturnsRandomFortune() {
		
		final HashMap<Integer, String> expected = new HashMap<Integer, String>(); 
	    
		when(mockService.getFortuneListSize()).thenReturn(40);
	    Map<Integer, String> response = subject.getRandomFortune();
	    assertThat(response.getClass().getSimpleName()).isEqualTo(expected.getClass().getSimpleName());
	}
}
