package com.animelista.animelista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animelista.animelista.models.Perfil;
import com.animelista.animelista.models.Usuario;
import com.animelista.animelista.repository.PerfilRepository;
import com.animelista.animelista.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Perfil cadastrarPerfil(Integer id ,@Valid Perfil perfil) {
		Usuario usuario = usuarioRepository.findById(id)
		.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
		
		perfil.setUsuario(usuario);
        usuario.setPerfil(perfil);
		
		return perfilRepository.save(perfil);

	}

	public Perfil exibirPerfilPorId(Integer idPerfil) {
		return perfilRepository.findById(idPerfil).get();

	}

	public void excluirPerfilPeloId(Perfil perfil) {
		perfilRepository.delete(perfil);
	}

	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}

	public Perfil atualizarPerfil(Integer idPerfil, @Valid Perfil perfilAtualizado) {

		if (this.perfilRepository.existsById(idPerfil)) {
			Perfil perfilAntigo = this.perfilRepository.findById(idPerfil).get();

			if (perfilAtualizado.getApelido() != null) {
				perfilAntigo.setApelido(perfilAtualizado.getApelido());
			}

			if (perfilAtualizado.getGenero() != null) {
				perfilAntigo.setGenero(perfilAtualizado.getGenero());
			}

			if (perfilAtualizado.getIdade() != null) {
				perfilAntigo.setIdade(perfilAtualizado.getIdade());
			}

			if (perfilAtualizado.getDataNascimento() != null) {
				perfilAntigo.setDataNascimento(perfilAtualizado.getDataNascimento());
			}

			if (perfilAtualizado.getLocalizacao() != null) {
				perfilAntigo.setLocalizacao(perfilAtualizado.getLocalizacao());
			}

			return perfilRepository.save(perfilAntigo);
		}

		throw new EntityNotFoundException("Usuário não encontrado com o ID: " + idPerfil);

	}
}
