package br.jessa.kafka.configuration;

import java.util.Properties;

import org.springframework.core.env.Environment;

public class ApiConfiguration {

	public final static Properties kafkaApi = new Properties();

	public synchronized void loadProperties(Environment environment) {
		ApiProperties[] values = ApiProperties.values();
		for (ApiProperties key : values) {
			String keyString = key.getProperties();
			if (key.isRequired())
				kafkaApi.put(keyString, environment.getRequiredProperty(keyString));
			else
				kafkaApi.put(keyString, environment.getProperty(keyString));
		}
	}
}
