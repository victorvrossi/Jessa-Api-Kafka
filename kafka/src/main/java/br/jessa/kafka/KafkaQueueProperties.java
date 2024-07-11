package br.jessa.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import br.jessa.kafka.serialization.EntityDeserializer;
import br.jessa.kafka.serialization.EntitySerializer;

public class KafkaQueueProperties {
	public enum ConfigureType {
		PRODUCER, CONSUMER, ADMIN
	}

	public static final String host = "192.168.50.110";
	public static final int port = 9095;

	public static String idress() {
		String ips = host + ":" + port;
		System.out.println("--" + ips);
		return ips;
	}

	public static Map<String, Object> map(ConfigureType type,KafkaProduceConfig producerConf) {
		return new KafkaQueueProperties().getMap(type,producerConf);
	}

	public Map<String, Object> getMap(ConfigureType type,KafkaProduceConfig producerConf) {
		Map<String, Object> m = new HashMap<String, Object>();

		configure(type,producerConf).entrySet().forEach(entry -> {
			m.put(entry.getKey().toString(), entry.getValue());
		});
		return m;
	}

	public static Properties getProducerConfig(KafkaProduceConfig producerConf) {
		return new KafkaQueueProperties().configure(ConfigureType.PRODUCER,producerConf);
	}

	public static Properties getConsumerConfig() {
		return new KafkaQueueProperties().configure(ConfigureType.CONSUMER,null);
	}

	protected Properties configure(ConfigureType type,KafkaProduceConfig producerConf) {
		Properties properties = new Properties();
		switch (type) {
		case CONSUMER: {
			consumerProperties(properties);break;
		}
		case PRODUCER: {
			produceProperties(properties,producerConf);break;
		}
		case ADMIN: {
			adminProperties(properties);break;
		}

		}

		return properties;
	}

	private void produceProperties(Properties properties, KafkaProduceConfig producerConf) {
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, idress());
		properties.put(ProducerConfig.CLIENT_ID_CONFIG, producerConf.getClientIdConfig());
		properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, producerConf.getTransactionalIdConfig());

		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EntitySerializer.class);

	}

	private void adminProperties(Properties properties) {
		properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, idress());
	}

	private void consumerProperties(Properties properties) {
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, idress());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "pagamentoGroup-1");
		properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "5");
		properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumerID");

		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EntityDeserializer.class);
	}
}
