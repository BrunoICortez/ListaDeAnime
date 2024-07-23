package com.animelista.animelista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animelista.animelista.dto.TrocaDeSenhaDTO;
import com.animelista.animelista.dto.UsuarioDTO;
import com.animelista.animelista.models.Usuario;
import com.animelista.animelista.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	public UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> buscarTodosOsUsuarios() {
		return this.usuarioService.findAll();
	}

	@PostMapping
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.cadastrarUsuario(usuario);
	}

	@GetMapping("/{id}")
	public UsuarioDTO exibirUsuarioPeloId(@PathVariable Integer id) {
		Usuario usuario = this.usuarioService.exibirUsuarioPeloId(id);
		return UsuarioDTO.retornoUsuario(usuario);
	}

	@DeleteMapping("/{id}")
	public void excluirUsuarioPeloId(Usuario usuario) {
		usuarioService.excluirUsuarioPeloId(usuario);
	}
	
	@PutMapping("/{id}")
	public UsuarioDTO atualizarUsuario(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
		return usuarioService.atualizarUsuario(id, usuario);
	}
	
	@PutMapping("/{id}/senha")
	public void atualizarSenha(@PathVariable Integer id,  @RequestBody  TrocaDeSenhaDTO trocaDeSenhaDTO) {
		usuarioService.trocaDeSenha(id, trocaDeSenhaDTO);
	}
}
