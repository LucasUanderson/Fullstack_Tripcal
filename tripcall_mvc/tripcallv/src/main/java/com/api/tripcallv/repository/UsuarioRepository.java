package com.api.tripcallv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tripcallv.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {

	boolean existByCpf(String cpf);
	boolean existByEmail(String email);
	
	
	
}
