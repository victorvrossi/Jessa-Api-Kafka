package br.jessa.kafka.generic;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.jessa.kafka.exception.KafkaApiException;

public class TratamentoTest {

	@Test
	public void testComErroMasSemException() throws Exception{
		ExceptionHandling<?> bol =new ExceptionHandling<>() {
			
			@Override
			public void action() throws Exception {
				throw new NullPointerException();
			}
		}.doAction(false);
		assertNotNull(bol);
	}
	
	@Test
	public void testExecucaoOK() throws Exception{
		ExceptionHandling<?> bol =new ExceptionHandling<>() {
			
			@Override
			public void action() throws Exception {
				
			}
		}.doAction(false);
		assertNotNull(bol);
	}
	@Test(expected = KafkaApiException.class)
	public void testLancandoException() throws Exception{
		new ExceptionHandling<>() {
			
			@Override
			public void action() throws Exception {
				throw new NullPointerException();
			}
		}.doAction(true);
	}
	
	
	@Test
	public void testExecucaoComRetornoObjetoOK() throws Exception{
		TestObject bol =new ExceptionHandling<TestObject>() {
			
			@Override
			public void action() throws Exception {
				setObject(new TestObject());
			}
		}.doAction(false).getObject();
		assertNotNull(bol);
	}
	
	class TestObject{}

}
