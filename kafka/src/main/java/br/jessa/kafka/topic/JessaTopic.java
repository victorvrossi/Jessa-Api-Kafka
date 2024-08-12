package br.jessa.kafka.topic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.jessa.kafka.exception.KafkaApiException;
import br.jessa.kafka.generic.KafkaApiValidation;

public final class JessaTopic {

	private static Set<Class<? extends ModelEnumTopic>> hashSetEnumTopic = new HashSet<Class<? extends ModelEnumTopic>>();
	private List<ModelEnumTopic> listTopics;

	public JessaTopic() {
		listTopics = new ArrayList<ModelEnumTopic>();
	}

	@SuppressWarnings("rawtypes")
	public static void registerArrayEnumTopic(Class[] e) {
		for (Class unit : e) {
			registerEnumTopic(unit);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void registerEnumTopic(Class e) {
		if (!KafkaApiValidation.checkEnumKafka(e))
			throw KafkaApiException.noReturnFound();
		hashSetEnumTopic.add((Class<? extends ModelEnumTopic>) e);

	}

	public void integrate() {
		hashSetEnumTopic.forEach(enumClass -> {
			for (ModelEnumTopic d : enumClass.getEnumConstants()) {
				listTopics.add(d);
			}
		});
	}

	public List<ModelEnumTopic> getListTopics() {
		return listTopics;
	}

}
