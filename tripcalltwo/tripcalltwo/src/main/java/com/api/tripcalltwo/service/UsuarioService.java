package com.api.tripcalltwo.service;

import java.util.List;

import com.api.tripcalltwo.Entity.UsuarioEntity;

public interface UsuarioService {
	
	List<UsuarioEntity> listaUsuarios();
	
	UsuarioEntity saveUsuario ( UsuarioEntity  usuarioEntity);
	
	UsuarioEntity updateUsuario(Long id,UsuarioEntity  usuarioEntity);
	
	void excluirUsuario (Long id);
	
	

}
