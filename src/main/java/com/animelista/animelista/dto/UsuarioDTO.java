package com.animelista.animelista.dto;

import com.animelista.animelista.models.Usuario;

import jakarta.persistence.Id;

public class UsuarioDTO {

	@Id
	private Integer id;

	private String usuario;

	private String email;

	public UsuarioDTO() {

	}

	public UsuarioDTO(Integer id, String usuario, String email) {
		this.id = id;
		this.usuario = usuario;
		this.email = email;
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.usuario = usuario.getUsuario();
		this.email = usuario.getEmail();
	}

	public static UsuarioDTO retornoUsuario(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getUsuario(), usuario.getEmail());
		return usuarioDTO;
	}

	public static Usuario retornoUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO.getId(), usuarioDTO.getUsuario(), usuarioDTO.getEmail());
		return usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
