package com.api.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.project.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
