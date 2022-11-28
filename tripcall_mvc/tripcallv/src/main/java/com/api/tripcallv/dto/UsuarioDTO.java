package com.api.tripcallv.dto;

import javax.validation.constraints.NotBlank;

public class UsuarioDTO {
     
	@NotBlank
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	@NotBlank
	private String cpf;
	
	
	
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
