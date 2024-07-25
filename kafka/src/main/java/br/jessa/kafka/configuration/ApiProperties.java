package br.jessa.kafka.configuration;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

public enum ApiProperties {

	API_NAME				("br.jessa.api.name",null,false),
	INSTANCE_ID				("br.jessa.api.instance.id",null,true),
	KAFKA_COMMON_SERVER		("jessa.spring.kafka.server",CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,true),
	KAFKA_COMMON_CLIENT		("jessa.spring.kafka.client",CommonClientConfigs.CLIENT_ID_CONFIG,true),
	
	KAFKA_PRODUCER_TRANSACTION		("jessa.spring.kafka.transaction",ProducerConfig.TRANSACTIONAL_ID_CONFIG ,true),
	KAFKA_PRODUCER_SERIALIZER_KEY	("jessa.spring.kafka.producer.key-serializer",ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG ,true),
	KAFKA_PRODUCER_SERIALIZER_VALUE	("jessa.spring.kafka.producer.value-serializer",ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG ,true),
	
	KAFKA_CONSUMER_TRANSACTION		("jessa.spring.kafka.transaction",ConsumerConfig.GROUP_ID_CONFIG ,true),                                
	KAFKA_CONSUMER_SERIALIZER_KEY	("jessa.spring.kafka.consumer.key-deserializer",ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG ,true),
	KAFKA_CONSUMER_SERIALIZER_VALUE	("jessa.spring.kafka.consumer.value-deserializer",ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG ,true),

	;

	private String properties;
	private Object mapped;
	private Boolean required;

	private ApiProperties(String properties,Object mapped, Boolean required) {
		this.properties = properties;
		this.required = required;
		this.mapped=mapped;
	}

	public String getProperties() {
		return properties;
	}

	public Boolean isRequired() {
		return required;
	}

	Object getPropertiesMapped() {
		if(mapped == null) {
			return properties;
		}
		return mapped;
	}

}
