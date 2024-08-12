package br.jessa.kafka.message;

import java.io.Serializable;


public class RecordPack<ET extends EntityModel> implements Serializable {

	private static final long serialVersionUID = -1943435929263680971L;

	private ET entity;
	//private String queueCode;

	public ET getEntity() {
		return entity;
	}

	public RecordPack<ET> setEntity(ET entity) {
		this.entity = entity;
		return this;
	}
	
	public RecordPack<ET> setTopic(String topic) {
		return this;
	}
	
	

}
