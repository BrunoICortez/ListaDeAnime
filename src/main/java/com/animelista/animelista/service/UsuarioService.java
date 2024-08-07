package com.animelista.animelista.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animelista.animelista.dto.TrocaDeSenhaDTO;
import com.animelista.animelista.dto.UsuarioDTO;
import com.animelista.animelista.models.Usuario;
import com.animelista.animelista.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario cadastrarUsuario(Usuario usuario) {
		usuario.setDataRegistro(LocalDateTime.now());
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();

	}

	public Usuario exibirUsuarioPeloId(Integer id) {
		return usuarioRepository.findById(id).get();
	}

	public void excluirUsuarioPeloId(Usuario usuario) {
		usuarioRepository.delete(usuario);

	}

	public UsuarioDTO atualizarUsuario(Integer id, @Valid Usuario usuarioNovo) {

		if (this.usuarioRepository.existsById(id)) {
			Usuario usuarioAntigo = this.usuarioRepository.findById(id).get();

			if (usuarioNovo.getUsuario() != null) {
				usuarioAntigo.setUsuario(usuarioNovo.getUsuario());
			}

			if (usuarioNovo.getEmail() != null) {
				usuarioAntigo.setEmail(usuarioNovo.getEmail());
			}

			Usuario usuarioAtualizado = this.usuarioRepository.save(usuarioAntigo);

			return converterParaDTO(usuarioAtualizado);
		}

		throw new EntityNotFoundException("Usuário não encontrado com o ID: " + id);

	}

	private UsuarioDTO converterParaDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setUsuario(usuario.getUsuario());
		usuarioDTO.setEmail(usuario.getEmail());
		return usuarioDTO;
	}

	public void trocaDeSenha(Integer id, TrocaDeSenhaDTO trocaDeSenhaDTO) {
		if (this.usuarioRepository.existsById(id)) {
			Usuario usuario = this.usuarioRepository.findById(id).get();

			String senhaUsuario = usuario.getSenha();

			if (senhaUsuario.equals(trocaDeSenhaDTO.getSenhaAntiga())) {
				usuario.setSenha(trocaDeSenhaDTO.getSenhaAtual());

				usuarioRepository.save(usuario);

			} else {
				throw new RuntimeException("Senha antiga incorreta");
			}
		} else {
			throw new RuntimeException("Usuário não encontrado");
		}
	}
}