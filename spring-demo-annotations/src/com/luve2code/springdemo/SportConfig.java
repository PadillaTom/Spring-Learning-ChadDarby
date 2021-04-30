package com.luve2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.luve2code.springdemo")
public class SportConfig {
	
	// Define Bean for SadFortune
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// Define Bean for SwimCoach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	
}
