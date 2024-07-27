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

import com.animelista.animelista.models.Perfil;
import com.animelista.animelista.service.PerfilService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	PerfilService perfilService;

	@GetMapping
	public List<Perfil> buscarTodosOsPerfis() {
		return this.perfilService.findAll();
	}

	@PostMapping("/usuario/{id}")
	public Perfil cadastrarPerfil(@PathVariable Integer id,@RequestBody Perfil perfil) {		
		return this.perfilService.cadastrarPerfil(id,perfil);
	}

	@GetMapping("/{idPerfil}")
	public Perfil exibirPerfilPeloId(@PathVariable Integer idPerfil) {
		return perfilService.exibirPerfilPorId(idPerfil);

	}

	@DeleteMapping("/{idPerfil}")
	public void excluirPerfilPeloId(Perfil perfil) {
		perfilService.excluirPerfilPeloId(perfil);
	}

	@PutMapping("/{idPerfil}")
	public Perfil atualizarPerfil(@PathVariable Integer idPerfil, @Valid @RequestBody Perfil perfil) {
		return perfilService.atualizarPerfil(idPerfil, perfil);
	}

}
