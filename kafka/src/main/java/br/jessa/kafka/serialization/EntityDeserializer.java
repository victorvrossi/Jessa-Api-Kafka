package br.jessa.kafka.serialization;

import java.io.ObjectInputStream;

import org.apache.kafka.common.serialization.Deserializer;

import br.jessa.kafka.exception.KafkaApiException;
import br.jessa.kafka.generic.ExceptionHandling;
import br.jessa.kafka.message.EntityModel;
import br.jessa.kafka.message.RecordPack;

public class EntityDeserializer<T extends RecordPack<? extends EntityModel>> implements Deserializer<T> {

	@Override
	public T deserialize(String topic, byte[] data) {
		return deserializarEntidade(data);
	}

	public T deserializarEntidade(byte[] data) {
		return new ExceptionHandling<T>() {
			@Override
			public void action() throws Exception {
				setObject(process(data));
			}
		}.doAction(true).getObject();
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	protected <T> T process(byte[] data) throws Exception {
		
		Object objectFromQueue = readFromQueue(data);

		if (objectFromQueue instanceof EntityModel) {
			RecordPack<EntityModel> newRecord = new RecordPack<EntityModel>();
			newRecord.setEntity((EntityModel) objectFromQueue);
			return ((T) newRecord);
		} else {
			KafkaApiException.validateConversionTo(objectFromQueue);
			return ((T) objectFromQueue);
		}
	}
	
	protected Object readFromQueue(byte[] data) throws Exception {
		ObjectInputStream objOutput;
		objOutput = new ObjectInputStream(new InputStreamSerializer(data));
		Object objectFromQueue = objOutput.readObject();
		objOutput.close();
		return objectFromQueue;
	}

}
