package br.jessa.kafka.producer;

public interface ProduceModel {

	public void initTransactions();
	public void beginTransaction();
	public void commitTransaction();
	public void abortTransaction();
	public void close();
}
