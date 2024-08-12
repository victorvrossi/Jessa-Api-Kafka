package br.jessa.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;

import br.jessa.kafka.message.EntityModel;
import br.jessa.kafka.message.RecordPack;

public interface ProduceModel<T extends EntityModel> {

	public void initTransactions();
	public void beginTransaction();
	public void commitTransaction();
	public void abortTransaction();
	public void close();
	public  Object send(ProducerRecord<String, RecordPack<T>> rec);
}
