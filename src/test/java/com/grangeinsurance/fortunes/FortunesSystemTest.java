package com.grangeinsurance.fortunes;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class FortunesSystemTest {

	 @Autowired
	  private MockMvc mockMvc;

	 @Test
	 void resourceReturnsFortunesList() throws Exception {
	  
		 mockMvc.perform(
	    	MockMvcRequestBuilders.get("/fortunes")
            .contentType("text/html"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
	 }
	  
	 @Test
	 void resourceReturnsFortunesByIDEightTeen() throws Exception {
		  
		  Integer id = 18;
		  String expectedVal = "{\"18\":\"Success is failure turned inside out.\"}";
		  mockMvc.perform(
	    	MockMvcRequestBuilders.get("/fortunes/{id}", id)
	            .contentType("text/html"))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andExpect(MockMvcResultMatchers.content().string(
	            	expectedVal.toString()));
	 }
	  
	 @Test
	 void resourceNotFoundFortunesByIDZero() throws Exception {
		  
		  Integer id = 0;
		  mockMvc.perform(
	    	MockMvcRequestBuilders.get("/fortunes/{id}", id)
	            .contentType("text/html"))
	            .andExpect(MockMvcResultMatchers.status().isNotFound());
	 }
	  
	 @Test
	 void resourceNotFoundFortunesByIDFortyTwo() throws Exception {
		  
		 Integer id = 42;
		 mockMvc.perform(
			 MockMvcRequestBuilders.get("/fortunes/{id}", id)
	 		 .contentType("text/html"))
       		 .andExpect(MockMvcResultMatchers.status().isNotFound());
	 }
	 
	 @Test
	 void resourceReturnsRandomFortune() throws Exception {
		  
		 mockMvc.perform(
			 MockMvcRequestBuilders.get("/fortunes/random")
			 .contentType("text/html"))
 			 .andExpect(MockMvcResultMatchers.status().isOk())
		 	 .andDo(MockMvcResultHandlers.print());
		 	
	 }
}
