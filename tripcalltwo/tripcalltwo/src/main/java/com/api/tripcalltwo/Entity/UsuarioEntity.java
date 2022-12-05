package com.api.tripcalltwo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name = "TB_USUARIOS")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message = "ATENÇÃO: Nome obrigatorio! ")
	@Column(name = "nome", length = 200, nullable =false)
	private String nome;
	
	@NotBlank(message = "ATENÇÃO: Senha obrigatorio!")
	@Size(min = 8, message = "A senha deve ter no minimo 8 caracteres")
	@Column(name = "senha", length = 500 , nullable =false)
	private String senha;
	
	@Email(message = "Insira um email válido!")
	@NotBlank(message = "ATENÇÃO: email obrigatorio!")
	@Column(name = "email", length = 150 , unique =true , nullable =false)
	private String email;
	
	@NotBlank(message = "ATENÇÃO: cpf obrigatorio!")
	@Column(name = "cpf", length = 15, unique = true, nullable =false)
	private String cpf;



}
