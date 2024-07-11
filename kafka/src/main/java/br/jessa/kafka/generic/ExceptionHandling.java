package br.jessa.kafka.generic;

import br.jessa.kafka.exception.KafkaApiException;

public abstract class ExceptionHandling<T> {

	public abstract void action() throws Exception;

	private T object;

	public ExceptionHandling<T> doAction(boolean outException) {

		try {
			action();
		} catch (Exception e) {
			if (Boolean.TRUE.equals(outException))
				lanca(e);
		}
		return this;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	private void lanca(Exception e) {
		KafkaApiException.exceptionJava(e);
	}
	
}
