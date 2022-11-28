package com.api.tripcallv.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tripcallv.dto.UsuarioDTO;
import com.api.tripcallv.model.UsuarioModel;
import com.api.tripcallv.service.UsuarioService;

@RestController
@RequestMapping("/sistema/conta")
public class UsuarioCadastroController {

	private final UsuarioService usuarioService;

	public UsuarioCadastroController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Object> saveUsuario(UsuarioDTO usuarioDTO) {

		if (usuarioService.existByCpf(usuarioDTO.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF ja esta em uso!");
		}
		if (usuarioService.existByEmail(usuarioDTO.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Email ja esta em uso!");
		}

		var usuarioModel = new UsuarioModel();
		BeanUtils.copyProperties(usuarioDTO, usuarioDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
	}

	@GetMapping
	public ResponseEntity<List<UsuarioModel>> getUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") Long id) {
		Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
		if (!usuarioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario com o id: " + id + "nao encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario (@PathVariable(value = "id")Long id){
		Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
		if(!usuarioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario com o id: " + id + "nao encontrado.");
		}
		usuarioService.delete(usuarioModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso");
	}
	
	@PutMapping
	public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id")Long id,@RequestBody @Valid UsuarioDTO usuarioDTO ){
		Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
		if(!usuarioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado");
		}
		var usuarioModel = usuarioModelOptional.get();
		
		usuarioModel.setNome(usuarioDTO.getNome());
		usuarioModel.setEmail(usuarioDTO.getEmail());
		usuarioModel.setSenha(usuarioDTO.getSenha());
		usuarioModel.setCpf(usuarioDTO.getCpf());
		
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuarioModel));
	}
	
}
