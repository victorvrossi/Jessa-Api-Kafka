package br.jessa.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import br.jessa.kafka.configuration.ApiConfiguration;
import br.jessa.kafka.message.EntityModel;
import br.jessa.kafka.message.RecordPack;

public class Producer<T extends EntityModel> implements ProduceModel<T> {
	private KafkaProducer<String, RecordPack<T>> kafkaProducer;

	public Producer() {
		kafkaProducer = new KafkaProducer<>(ApiConfiguration.kafkaApi());
	}

	@Override
	public void initTransactions() {
		kafkaProducer.initTransactions();
	}

	@Override
	public void beginTransaction() {
		kafkaProducer.beginTransaction();

	}

	@Override
	public void commitTransaction() {
		kafkaProducer.commitTransaction();
	}

	@Override
	public void abortTransaction() {
		kafkaProducer.abortTransaction();
	}

	@Override
	public void close() {
		kafkaProducer.close();
	}

	public Object send(ProducerRecord<String, RecordPack<T>> rec) {
		return kafkaProducer.send(rec);
	}

}
