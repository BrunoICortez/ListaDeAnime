package com.animelista.animelista.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.animelista.animelista.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Optional<Usuario> findById(Integer id);

}
