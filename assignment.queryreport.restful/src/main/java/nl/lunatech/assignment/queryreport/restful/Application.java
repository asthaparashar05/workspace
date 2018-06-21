package nl.lunatech.assignment.queryreport.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main Application class
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="nl.lunatech.assignment.queryreport.restful")

public class Application 
{
	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(Application.class, args);
		 
	    }
}
