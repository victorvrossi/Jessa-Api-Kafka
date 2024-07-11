package br.jessa.kafka.configuration;

public enum ApiProperties {

	API_NAME("br.jessa.api.name",false),
	HOST_IP("br.jessa.kafka.host",true);

	private String properties;
	private Boolean required;

	private ApiProperties(String properties, Boolean required) {
		this.properties = properties;
		this.required = required;
	}

	public String getProperties() {
		return properties;
	}

	public Boolean isRequired() {
		return required;
	}

}
