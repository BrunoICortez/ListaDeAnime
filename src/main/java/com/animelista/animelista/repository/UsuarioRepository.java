package com.animelista.animelista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animelista.animelista.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
}
