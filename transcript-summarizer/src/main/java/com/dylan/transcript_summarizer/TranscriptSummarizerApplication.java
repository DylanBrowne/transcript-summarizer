package com.dylan.transcript_summarizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Transcript Summarizer application.
 * 
 * The @SpringBootApplication annotation is a convenience annotation that adds all of the following:
 * 
 * @Configuration: Tags the class as a source of bean definitions for the 
 * application context.
 * 
 * @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on 
 * classpath settings, other beans, and various property settings.
 * 
 * @ComponentScan: Tells Spring to look for other components, configurations, 
 * and services in the com/dylan/transcript_summarizer package, allowing it to
 * find the controllers.
 */
@SpringBootApplication
public class TranscriptSummarizerApplication {

	// This is the main entry point of the Spring Boot application. It initializes and runs the application context.
	public static void main(String[] args) {
		// Start the Spring Boot application
		SpringApplication.run(TranscriptSummarizerApplication.class, args);
	}

}
