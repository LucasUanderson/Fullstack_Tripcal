package com.api.tripcallv.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.api.tripcallv.model.UsuarioModel;
import com.api.tripcallv.repository.UsuarioRepository;

public class UsuarioService {
	
	
	final UsuarioRepository usuarioRepository;
     
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}	
	
	@Transactional
	public UsuarioModel save(UsuarioModel usuarioModel) {
		return usuarioRepository.save(usuarioModel);
	}

	public  boolean existByCpf(String cpf) {
		return usuarioRepository.existByCpf(cpf);
	}

	public boolean existByEmail(String email) {
		return usuarioRepository.existByEmail(email);
	}

	public List<UsuarioModel> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Optional<UsuarioModel> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	
	@Transactional
	public void delete(UsuarioModel usuarioModel) {
		usuarioRepository.delete(usuarioModel);
     
	}

	

}

	