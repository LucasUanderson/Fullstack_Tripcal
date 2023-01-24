package com.api.tripcalltwo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.tripcalltwo.Entity.UsuarioEntity;
import com.api.tripcalltwo.service.UsuarioServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	
	private final UsuarioServiceImpl usuarioService;
	
	public UsuarioController(UsuarioServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
	}
		
	
	@GetMapping
	public ResponseEntity<List<UsuarioEntity>> getUsuarios(){
	    return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listaUsuarios());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioEntity> criarUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuarioEntity));
	}
	
	@PutMapping("/editar")
	public ResponseEntity<UsuarioEntity> editarrUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioEntity usuarioEntity){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.saveUsuario(usuarioEntity));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioEntity> excluirUsuario(@PathVariable Long id){
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
		
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException exception){
		Map<String, String> errors = new HashMap<>();
		
		exception.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName = ((FieldError)error).getField();
			String errorMenssage = error.getDefaultMessage(); 
			errors.put(fieldName, errorMenssage);
		});
		
		return errors;
	}
}
