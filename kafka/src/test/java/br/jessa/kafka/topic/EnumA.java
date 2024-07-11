package br.jessa.kafka.topic;

public enum EnumA implements ModelEnumTopic {
	TOPIC_TEST("topicTest", 1, Short.valueOf("1"));

	
	
	private String topicName;
	private int topicPartition;
	private short topicReplication;

	private EnumA(String topic, int topicPartition, short topicReplication) {
		this.topicName = topic;
		this.topicPartition=topicPartition;
		this.topicReplication=topicReplication;
	}

		

	public String getTopicName() {
		return topicName;
	}

	public int getTopicPartition() {
		return topicPartition;
	}

	public short getTopicReplication() {
		return topicReplication;
	}

}
