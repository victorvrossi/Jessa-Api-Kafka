package br.jessa.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;

import br.jessa.kafka.message.EntityModel;
import br.jessa.kafka.message.RecordPack;
import br.jessa.kafka.topic.ModelEnumTopic;

public class FactoryProducerRecord {

	
	@SuppressWarnings("rawtypes")
	public static <P extends ModelEnumTopic,T extends EntityModel> ProducerRecord<String, RecordPack> recordSet(P topic,T val) {

		RecordPack<T> p = new RecordPack<T>();
		p.setEntity(val);
		return new ProducerRecord<String, RecordPack>(topic.getTopicName(), p);
	}

}
