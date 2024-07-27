package com.animelista.animelista.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPerfil;

	private String apelido;
	private String genero;
	private Integer idade;
	private LocalDate dataNascimento;
	private String localizacao;

	@OneToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	public Perfil() {

	}

	public Perfil(Integer idPerfil, String apelido, String genero, Integer idade, LocalDate dataNascimento,
			String localizacao, Usuario usuario) {

		this.idPerfil = idPerfil;
		this.apelido = apelido;
		this.genero = genero;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
		this.localizacao = localizacao;
		this.usuario = usuario;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
