package br.jessa.kafka.serialization;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class OutputStreamSerializer extends OutputStream {
	private List<Byte> listBytes;

	public OutputStreamSerializer(List<Byte> listBytes) {
		super();
		this.listBytes = listBytes;
	}

	@Override
	public void write(int b) throws IOException {
		listBytes.add(Byte.decode(Integer.toString(b)));
	}
}
