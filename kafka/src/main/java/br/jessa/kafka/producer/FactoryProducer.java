package br.jessa.kafka.producer;

import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;

import br.jessa.kafka.message.EntityModel;
import br.jessa.kafka.message.RecordPack;

public class FactoryProducer<U extends EntityModel, Y extends ProduceModel<U>> {

	private Y producer;

	private FactoryProducer(Y producer) {
		this.producer = producer;
	}

	public static <Z extends EntityModel, X extends ProduceModel<Z>> FactoryProducer<Z, X> newInstance(X producer) {
		return new FactoryProducer<>(producer);
	}

	public void sendList(List<ProducerRecord<String, RecordPack<U>>> list) {
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

	public void send(ProducerRecord<String, RecordPack<U>> message) {
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
