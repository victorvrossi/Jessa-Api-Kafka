package br.jessa.kafka.topic;

public interface ModelEnumTopic {
	
	public String getTopicName();

	public int getTopicPartition();

	public short getTopicReplication();
}
