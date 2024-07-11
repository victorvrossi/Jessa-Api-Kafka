package br.jessa.kafka;

import java.util.Properties;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import br.jessa.kafka.configuration.ApiConfiguration;
import br.jessa.kafka.configuration.ApiProperties;

@SpringBootApplication
public class KafkaApiApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(KafkaApiApplication.class, args);		
		
	}
	
	@Bean
    ApplicationRunner applicationRunner(Environment environment) {
		
        return args -> {
        	new ApiConfiguration().loadProperties(environment);
        	//System.out.println ("message from application.properties :" + environment.getProperty("spring.application.name"));
        };
    }

	
}
