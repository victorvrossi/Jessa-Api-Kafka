package br.jessa.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import br.jessa.kafka.configuration.ApiConfiguration;
import br.jessa.kafka.message.RecordPack;

public class Producer implements ProduceModel {
	@SuppressWarnings("rawtypes")
	private KafkaProducer<String, RecordPack> producer ;
	
	
	@SuppressWarnings("rawtypes")
	public Producer(String producerName) {
		producer = new KafkaProducer<String, RecordPack>(ApiConfiguration.kafkaApi);		
	}
	
	@Override
	public void initTransactions() {
		producer.initTransactions();		
	}

	@Override
	public void beginTransaction() {
		producer.beginTransaction();
		
	}

	@Override
	public void commitTransaction() {
		producer.commitTransaction();
	}

	@Override
	public void abortTransaction() {
		producer.abortTransaction();
	}

	@Override
	public void close() {
		producer.close();
	}

	@SuppressWarnings("rawtypes")
	public Object send(ProducerRecord<String, RecordPack> rec) {
		return producer.send(rec);
	}

}
