package br.jessa.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import br.jessa.kafka.KafkaProduceConfig;
import br.jessa.kafka.KafkaQueueProperties;
import br.jessa.kafka.message.RecordPack;

public class Producer implements ProduceModel {
	@SuppressWarnings("rawtypes")
	private KafkaProducer<String, RecordPack> producer ;
	
	@SuppressWarnings("rawtypes")
	public Producer(String producerName) {
		KafkaProduceConfig producerConf = new KafkaProduceConfig();
		producerConf
			.setClientIdConfig("Client_"+producerName)
			.setTransactionalIdConfig("Transaction_"+producerName);
		
		producer = new KafkaProducer<String, RecordPack>(KafkaQueueProperties.getProducerConfig(producerConf));
		
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
