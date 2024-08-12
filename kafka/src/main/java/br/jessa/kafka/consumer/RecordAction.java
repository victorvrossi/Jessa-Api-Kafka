package br.jessa.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import br.jessa.kafka.generic.ExceptionHandling;
import br.jessa.kafka.message.EntityModel;
import br.jessa.kafka.message.RecordPack;
import br.jessa.kafka.producer.FactoryProducer;
import br.jessa.kafka.producer.FactoryProducerRecord;
import br.jessa.kafka.producer.ProduceModel;
import br.jessa.kafka.topic.ModelEnumTopic;

public abstract class RecordAction<T extends EntityModel> {

	public abstract void actionRecord(T item);

	public abstract void whenActionFail();
	
	private T entity;

	protected <E extends ModelEnumTopic, P extends ProduceModel<T>> void  remap(E testeFail, P producer) {
		FactoryProducer.newInstance(producer)
		.send(FactoryProducerRecord.recordSet(testeFail,entity));
	}

	void extractEntity(ConsumerRecord<String, RecordPack<T>> consumerRecord) {
		RecordPack<T> pack = consumerRecord.value();
		entity= pack.getEntity();
	}

	void processRecord(ConsumerRecord<String, RecordPack<T>> consumerRecord) {
		extractEntity(consumerRecord);
		try {
			actionRecord(entity);
		} catch (Throwable e) {
			new ExceptionHandling<T>() {
				@Override
				public void action() throws Throwable {
					whenActionFail();
				}
			}.doAction(true);
		}
	}

}
