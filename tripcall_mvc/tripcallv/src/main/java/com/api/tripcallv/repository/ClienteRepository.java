package com.api.tripcallv.repository;

import org.springframework.data.repository.CrudRepository;
import com.api.tripcallv.model.ClienteModel;

public interface ClienteRepository extends CrudRepository<ClienteModel,Long> {

	
	boolean existsBySenha(String senha);
	boolean existsByCpf(String cpf);

}
