package com.grangeinsurance.fortunes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ErrorObjectTest {

	private ErrorObject subject;
	
	@BeforeEach
	void initialize() {
		subject = new ErrorObject(404, "test", 123456789);
	}
	
	@Test
	void getStatusCode() {
		assertThat(subject.getStatusCode()).isEqualTo(404);
	}
	
	@Test
	void setStatusCode() {
		subject.setStatusCode(200);
		assertThat(subject.getStatusCode()).isEqualTo(200);
	}
	
	@Test
	void getMessage() {
		assertThat(subject.getMessage()).isEqualTo("test");
	}
	
	@Test
	void setMessage() {
		subject.setMessage("JUnit Test");
		assertThat(subject.getMessage()).isEqualTo("JUnit Test");
	}
	
	@Test
	void getTimestamp() {
		assertThat(subject.getTimestamp()).isEqualTo(123456789);
	}
	
	@Test
	void setTimestamp() {
		subject.setTimestamp(987654321);
		assertThat(subject.getTimestamp()).isEqualTo(987654321);
	}
}
