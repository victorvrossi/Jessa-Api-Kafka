package br.jessa.kafka.exception;

import br.jessa.kafka.message.RecordPack;

public class KafkaApiException extends RuntimeException {

	private static final long serialVersionUID = -3781086866950939836L;

	public KafkaApiException(String msg) {
		super(msg);
	}

	public static void validateConversionTo(Object b) {
		verifyObjectNull(b);
		if (b instanceof RecordPack)
			return;

		StringBuilder msg = new StringBuilder();
		msg.append(b.getClass().getName());
		msg.append(">Objeto não é uma instancia de:");
		msg.append(RecordPack.class.getName());

		throw new KafkaApiException(msg.toString());

	}

	public static void verifyObjectNull(Object b) {
		if (b == null)
			throw new KafkaApiException("Detectado objeto NULL");
	}

	public static void print(String string, Exception e) {
		throw new KafkaApiException("Houve um erro:" + string + " - " + e.getStackTrace());
	}

	public static void exceptionJava(Exception e) {
		throw new KafkaApiException("Houve um erro:" + e.getMessage());
	}

	public static KafkaApiException noReturnFound() {
		return new KafkaApiException("Execução não retornou resultado válid");
	}

	

}
