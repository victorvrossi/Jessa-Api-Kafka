package br.jessa.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;

public class FactoryTopic {

	private JessaTopic localTopic;

	public FactoryTopic() {
		localTopic = new JessaTopic ();
	}
	
	public void create() {
		localTopic.integrate();
		localTopic.getListTopics().forEach(item->{
			NewTopic o=new NewTopic(item.getTopicName(), item.getTopicPartition(),item.getTopicReplication());
			System.out.println(o.toString());
		});
		
	}

}
