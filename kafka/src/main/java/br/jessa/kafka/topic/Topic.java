package br.jessa.kafka.topic;

import java.util.HashSet;
import java.util.Set;

import br.jessa.kafka.exception.KafkaApiException;

public final class Topic <E extends Enum<E>>  {

	private static  Set<Class<? extends ModelEnumTopic>> hasSetEnumTopic = new HashSet<Class< ? extends ModelEnumTopic>>();
	
	
	@SuppressWarnings("unchecked")
	public static <E extends Enum<E>>  void registerEnumTopic(Class<E> e) {
		
		for(Class<?> o :e.getInterfaces()) {
			System.out.println(">"+o.getName());
			if(ModelEnumTopic.class.equals(o)) {
				hasSetEnumTopic.add((Class<? extends ModelEnumTopic>) e);
				return;
			}
		}
		KafkaApiException.noReturnFound();
	}
}
