package com.api.tripcalltwo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity(name = "Usuario")
@Table(
		name = "usuario",
		uniqueConstraints = {
			    @UniqueConstraint(
						name = "usuario_email_unique", 
						columnNames = "email"
						),
				@UniqueConstraint(
						name = "usuario_cpf_unique",
						columnNames = "cpf"
			            )
	}
)
public class UsuarioEntity {
	
	@Id
	@SequenceGenerator(
			name = "usuario_sequence",
			sequenceName = "usuario_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "usuario_sequence"			
	)
	@Column(
			name = "id",
			updatable = false
	)
	private Long id;
	@NotBlank(
			message = "ATENÇÃO: Nome obrigatorio!"
	)
	@Column(
			name = "nome", 
			length = 200, 
			nullable =false,
			columnDefinition = "TEXT"
	)
	private String nome;
	@NotBlank(
			message = "ATENÇÃO: Senha obrigatorio!"
	)
	@Size(
			min = 8, 
			message = "A senha deve ter no minimo 8 caracteres"
	)
	@Column(
			name = "senha", 
			length = 500 , 
			nullable =false
    )
	private String senha;
	@Email(
			message = "Insira um email válido!"
	)
	@NotBlank(
			message = "ATENÇÃO: email obrigatorio!"
	)
	@Column(
			name = "email", 
			length = 150 , 
			nullable =false,
			columnDefinition = "TEXT"
	)
	private String email;
	@NotBlank(
			message = "ATENÇÃO: cpf obrigatorio!"
	)
	@Column(
			name = "cpf", 
			length = 15, 
			nullable =false
	)
	private String cpf;

}
