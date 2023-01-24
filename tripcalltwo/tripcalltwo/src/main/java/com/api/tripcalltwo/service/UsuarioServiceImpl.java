package com.api.tripcalltwo.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.tripcalltwo.Entity.UsuarioEntity;
import com.api.tripcalltwo.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
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
	
	public UsuarioEntity updateUsuario(Long id,UsuarioEntity usuarioEntity) {
		String encoder = this.passwordEncoder.encode(usuarioEntity.getSenha());
		usuarioEntity.setSenha(encoder);
		UsuarioEntity usuarioNovo = usuarioRepository.save(usuarioEntity);
		return usuarioNovo;
	}
	
	public void excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);
		
		
	}

	
	


}
