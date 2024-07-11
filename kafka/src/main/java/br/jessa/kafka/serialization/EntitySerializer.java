package br.jessa.kafka.serialization;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.common.serialization.Serializer;

import br.jessa.kafka.generic.ExceptionHandling;
import br.jessa.kafka.message.RecordPack;

public class EntitySerializer<T extends RecordPack<?>> implements Serializer<T> {

	
	@Override
	public byte[] serialize(String topic, T data) {
		data.setTopic(topic);
		return serializarEntidade(data);
	}

	protected List<Byte> listBytes = new ArrayList<Byte>();

	protected byte[] serializarEntidade(T entity) {
		new ExceptionHandling<Object>() {
			@Override
			public void action() throws Exception {
				process(entity);
			}
		}.doAction(true);
		return convert(listBytes);
	}
	
	@SuppressWarnings("hiding")
	protected <T> void process(T entity) throws Exception {
		OutputStreamSerializer str = new OutputStreamSerializer(listBytes);
		ObjectOutputStream objOutput = new ObjectOutputStream(str);
		objOutput.writeObject(entity);
		objOutput.close();
	}

	
	private byte[] convert(List<Byte> listBytes) {
		byte[] data = new byte[listBytes.size()];
		int i = 0;
		for (Byte classByte : listBytes) {
			data[i] = classByte.byteValue();
			i++;
		}
		return data;
	}

	
}
