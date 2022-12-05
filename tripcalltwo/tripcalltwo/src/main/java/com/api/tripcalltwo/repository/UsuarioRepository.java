package com.api.tripcalltwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tripcalltwo.Entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
