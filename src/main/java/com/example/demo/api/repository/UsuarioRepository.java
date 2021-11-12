package com.example.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
