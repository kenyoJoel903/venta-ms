package com.kenyo.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenyo.productos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
