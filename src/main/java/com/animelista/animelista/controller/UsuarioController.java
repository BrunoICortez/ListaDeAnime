package com.animelista.animelista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animelista.animelista.dto.UsuarioDTO;
import com.animelista.animelista.models.Usuario;
import com.animelista.animelista.service.UsuarioService;

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
}
