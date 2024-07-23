package com.animelista.animelista.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Perfil {

	private String apelido;
	private String genero;
	private Integer idade;
	private LocalDate dataNascimento;
	private String localizacao;

	public Perfil() {
		
	}

	public Perfil(String apelido, String genero, Integer idade, LocalDate dataNascimento, String localizacao) {

		this.apelido = apelido;
		this.genero = genero;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
		this.localizacao = localizacao;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

}
