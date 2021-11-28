package com.example.demo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.api.model.Saida;
import com.example.demo.api.model.TipoEntrada;

public interface TipoEntradaRepository extends JpaRepository<TipoEntrada, Long>{

	@Query(value = "select * from tipo_entrada ORDER BY nome" , nativeQuery = true)
	List<TipoEntrada> buscarAll();
}
