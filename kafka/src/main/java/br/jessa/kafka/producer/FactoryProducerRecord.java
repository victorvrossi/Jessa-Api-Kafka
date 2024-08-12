package br.jessa.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;

import br.jessa.kafka.message.EntityModel;
import br.jessa.kafka.message.RecordPack;
import br.jessa.kafka.topic.ModelEnumTopic;

public class FactoryProducerRecord {
	public static 
	<P extends ModelEnumTopic,T extends EntityModel> ProducerRecord<String,RecordPack<T>> 
	recordSet(P topic,T val) {
		RecordPack<T> p = new RecordPack<>();
		p.setEntity(val);
		return new ProducerRecord<>(topic.getTopicName(), p);
	}

}
