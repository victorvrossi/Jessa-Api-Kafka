package br.jessa.kafka.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

import br.jessa.kafka.exception.KafkaApiException;
import br.jessa.kafka.message.RecordPack;

public class EntitySerializerTest {

	@Test
	public void test() {
		String validate = "Teste " + new Random().nextInt();
		RecordPack<Produto> rp = prepare(validate);

		EntitySerializer<RecordPack<Produto>> sx = new EntitySerializer<RecordPack<Produto>>();
		EntityDeserializer<RecordPack<Produto>> dx = new EntityDeserializer<>();

		byte[] bt = sx.serializarEntidade(rp);
		sx.close();
		assertNotNull(bt);
		RecordPack<Produto> o = dx.deserializarEntidade(bt);
		dx.close();
		assertEquals("Verifica se nome foi processado com sucesso", validate, o.getEntity().getNome());
		
		
	}

	@Test(expected = KafkaApiException.class)
	public void test2() {
		String validate = "Teste " + new Random().nextInt();
		RecordPack<Produto> rp = prepare(validate);

		EntitySerializer<RecordPack<Produto>> sx = new EntitySerializer<RecordPack<Produto>>();
		EntityDeserializer<RecordPack<Produto>> dx = new EntityDeserializer<>();

		sx.listBytes = null;
		byte[] bt = sx.serializarEntidade(rp);
		sx.close();
		assertNotNull(bt);
		RecordPack<Produto> o = dx.deserializarEntidade(bt);
		dx.close();
		assertEquals("Verifica se nome foi processado com sucesso", validate, o.getEntity().getNome());

	}

	private RecordPack<Produto> prepare(String validate) {
		Produto s = new Produto();
		s.setNome(validate);
		RecordPack<Produto> rp = new RecordPack<Produto>();
		rp.setEntity(s);
		return rp;
	}

}
