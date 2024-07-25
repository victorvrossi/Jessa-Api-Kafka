package br.jessa.kafka.configuration;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;

public class ApiConfiguration {

	public final static Properties kafkaApi = new Properties();
	protected static final Logger log = LogManager.getLogger();

	public synchronized void loadProperties(Environment environment) {
		ApiProperties[] values = ApiProperties.values();
		System.out.println("Carregando propriedades:" + values.length);
		for (ApiProperties key : values) {
			putKafkaConfs(key.getPropertiesMapped(), verifyRequiredProperties(key, environment));
		}

	}

	private Object verifyRequiredProperties(ApiProperties key, Environment environment) {
		if (key.isRequired())
			return environment.getRequiredProperty(key.getProperties());
		return environment.getProperty(key.getProperties());
	}

	private void putKafkaConfs(Object key, Object value) {
		if (value == null)
			return;
		kafkaApi.put(key, value);
	}

}
