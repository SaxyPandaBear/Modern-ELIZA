package com.eliza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan
@Configuration

@SpringBootApplication
public class ElizabotApplication {
	public static final String ACCOUNT_SID = "AC3463f320f49b6277cf87de69a066b7ed";
	public static final String AUTH_TOKEN = "9734539c1f72919cd1e004a9b49b4cbf";

	public static void main(String[] args) {
		SpringApplication.run(ElizabotApplication.class, args);
	}
}
