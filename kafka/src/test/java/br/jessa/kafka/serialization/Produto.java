package br.jessa.kafka.serialization;

import br.jessa.kafka.message.EntityModel;

public class Produto implements EntityModel{
	
	private static final long serialVersionUID = -6005960400116652032L;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + "]";
	}
	

	
}
