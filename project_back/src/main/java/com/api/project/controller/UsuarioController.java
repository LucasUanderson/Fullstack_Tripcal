package com.api.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.model.UsuarioModel;
import com.api.project.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private  UsuarioRepository usuarioRepository;

	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping
	public List<UsuarioModel> listUsuarios(){
		return (List<UsuarioModel>) usuarioRepository.findAll();
	}
	
	@PostMapping
	public UsuarioModel saveUsuario (@RequestBody UsuarioModel usuarioModel ) {
		UsuarioModel usuarioNovo = usuarioRepository.save(usuarioModel);
		return usuarioNovo;
	}
	
	@PutMapping
	public UsuarioModel UpdateUsuario (@RequestBody UsuarioModel usuarioModel ) {
		UsuarioModel usuarioNovo = usuarioRepository.save(usuarioModel);
		return usuarioNovo;
	}

}
