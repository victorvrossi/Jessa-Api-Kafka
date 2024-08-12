package br.jessa.kafka.consumer;

import java.time.Duration;
import java.util.Collections;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import br.jessa.kafka.configuration.ApiConfiguration;
import br.jessa.kafka.message.EntityModel;
import br.jessa.kafka.message.RecordPack;
import br.jessa.kafka.topic.ModelEnumTopic;

public class Consumer<E extends EntityModel>  {

	private KafkaConsumer<String,  RecordPack<E>> consumer;

	public Consumer() {
		consumer = new KafkaConsumer<>(ApiConfiguration.kafkaApi());
	}

	public <T extends ModelEnumTopic> void from(T teste,RecordAction<E> action) {
		Duration timeout = Duration.ofSeconds(Long.parseLong("5"));
		
		consumer.subscribe(Collections.singleton(teste.getTopicName()));
		ConsumerRecords<String,  RecordPack<E>> captureRecords = consumer.poll(timeout);
		for(ConsumerRecord<String,  RecordPack<E>> consumerRecord:captureRecords) {
			action.processRecord(consumerRecord);
		}
		consumer.commitSync();
		
	}
}
