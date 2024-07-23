package com.animelista.animelista.dto;

public class TrocaDeSenhaDTO {

	private String SenhaAntiga;
	private String SenhaAtual;

	public TrocaDeSenhaDTO() {

	}

	public TrocaDeSenhaDTO(String senhaAntiga, String senhaAtual) {
		SenhaAntiga = senhaAntiga;
		SenhaAtual = senhaAtual;
	}

	public String getSenhaAntiga() {
		return SenhaAntiga;
	}

	public void setSenhaAntiga(String senhaAntiga) {
		SenhaAntiga = senhaAntiga;
	}

	public String getSenhaAtual() {
		return SenhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		SenhaAtual = senhaAtual;
	}

}
