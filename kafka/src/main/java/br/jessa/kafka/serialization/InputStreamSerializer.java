package br.jessa.kafka.serialization;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamSerializer extends InputStream {
	private int atualPosicao = 0;

	private byte[] data;
	
	public InputStreamSerializer(byte[] data) {
		super();
		this.data = data;
	}

	@Override
	public int read() throws IOException {
		byte next = getNextPosition();
		return next;
	}

	public byte getNextPosition() {		
		return data[atualPosicao++];
	}
}
