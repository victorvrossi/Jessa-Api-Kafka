package br.jessa.kafka.topic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import br.jessa.kafka.exception.KafkaApiException;

public class TopicTest {

	@Test(expected = KafkaApiException.class)
	public void testB() {
		JessaTopic.registerEnumTopic(EnumB.class);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testA() {
		JessaTopic.<EnumA>registerEnumTopic(EnumA.class);
	}
	@SuppressWarnings("unused")
	@Test
	public void tex() {
		JessaTopic.<EnumA>registerEnumTopic(EnumA.class);
		JessaTopic o = new JessaTopic();
		o.integrate();
		List<ModelEnumTopic> li = o.getListTopics();
		assertEquals(1, li.size());
	}
	
	
}
