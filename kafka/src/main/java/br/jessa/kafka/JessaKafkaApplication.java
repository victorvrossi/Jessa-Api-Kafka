package br.jessa.kafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import br.jessa.kafka.configuration.ApiConfiguration;
import br.jessa.kafka.topic.FactoryTopic;
@Configuration
public class JessaKafkaApplication {
	
	@Bean
	ApplicationRunner applicationRunner(Environment environment) {
		return args -> {
			new FactoryTopic().create();
			new ApiConfiguration().loadProperties(environment);
		};
	}

}
