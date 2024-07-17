package com.animelista.animelista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animelista.animelista.models.Usuario;
import com.animelista.animelista.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {	
	
	@Autowired
	public UsuarioService usuarioService;
	
	
	@GetMapping
	public List<Usuario> buscarTodosOsUsuarios(){
		return usuarioService.findAll();
	}
	
	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);		
	}
}
