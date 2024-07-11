package br.jessa.kafka;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProduceConfig {
	private String clientIdConfig;
	private String transactionalIdConfig;

	public String getClientIdConfig() {
		return clientIdConfig;
	}

	public KafkaProduceConfig setClientIdConfig(String clientIdConfig) {
		this.clientIdConfig = clientIdConfig;
		return this;
	}

	public String getTransactionalIdConfig() {
		return transactionalIdConfig;
	}

	public KafkaProduceConfig setTransactionalIdConfig(String transactionalIdConfig) {
		this.transactionalIdConfig = transactionalIdConfig;
		return this;
	}

}
