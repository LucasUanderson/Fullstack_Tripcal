package com.api.tripcalltwo.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.tripcalltwo.Entity.UsuarioEntity;
import com.api.tripcalltwo.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	
	private UsuarioRepository usuarioRepository;
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public List<UsuarioEntity> listaUsuarios(){
		List<UsuarioEntity> lista = usuarioRepository.findAll();
	    return lista;
	}
	
	public UsuarioEntity saveUsuario(UsuarioEntity usuarioEntity){
		String encoder = this.passwordEncoder.encode(usuarioEntity.getSenha());
		usuarioEntity.setSenha(encoder);
		UsuarioEntity usuarioNovo = usuarioRepository.save(usuarioEntity);
		return usuarioNovo;
	}
	
	public UsuarioEntity updateUsuario(UsuarioEntity usuarioEntity) {
		String encoder = this.passwordEncoder.encode(usuarioEntity.getSenha());
		usuarioEntity.setSenha(encoder);
		UsuarioEntity usuarioNovo = usuarioRepository.save(usuarioEntity);
		return usuarioNovo;
	}
	
	public Boolean excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);
		return true;
		
	}
	

	//Validador de senha login
	public Boolean validarSenha(UsuarioEntity usuarioEntity) {
		String senha = usuarioRepository.getReferenceById(usuarioEntity.getId()).getSenha();
		Boolean valido =passwordEncoder.matches(usuarioEntity.getSenha(), senha);
		return valido;
	}

	


}
