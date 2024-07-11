package br.jessa.kafka.topic;

import org.junit.Test;

import br.jessa.kafka.exception.KafkaApiException;

public class TopicTest {

	@Test(expected = KafkaApiException.class)
	public void testB() {
		Topic.registerEnumTopic(EnumB.class);
	}
	@Test
	public void testA() {
		Topic.registerEnumTopic(EnumA.class);
	}

}
