package br.jessa.kafka.producer;

import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;

import br.jessa.kafka.message.RecordPack;

public class FactoryProducer {

	private Producer producer;
	
	private FactoryProducer(String name) {
		producer = new Producer(name);
		
		
	}
	
	public static FactoryProducer newInstance(String name) {
		return new FactoryProducer(name);
	}
	
	@SuppressWarnings("rawtypes")
	public void sendList(List<ProducerRecord<String, RecordPack>> list) {
		producer.initTransactions();
		producer.beginTransaction();
		try {
			list.forEach(rec -> producer.send(rec));		
			producer.commitTransaction();
		} catch (Exception e) {
			producer.abortTransaction();
		} finally {
			producer.close();
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	public  void  send(ProducerRecord<String, RecordPack> message) {
		producer.initTransactions();
		producer.beginTransaction();
		try {
			 producer.send(message);		
			producer.commitTransaction();
		} catch (Exception e) {
			producer.abortTransaction();
		} finally {
			producer.close();
		}
	}
}
