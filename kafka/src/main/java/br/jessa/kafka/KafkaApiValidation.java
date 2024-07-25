package br.jessa.kafka;

import br.jessa.kafka.topic.ModelEnumTopic;

public class KafkaApiValidation {
	
	@SuppressWarnings("rawtypes")
	public static Boolean checkEnumKafka(Class e) {
		if (!e.isEnum())
			return Boolean.FALSE;
		for (Class o : e.getInterfaces()) {
			if (ModelEnumTopic.class.equals(o)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

}
