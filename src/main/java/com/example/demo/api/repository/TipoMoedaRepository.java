package com.example.demo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.api.model.Saida;
import com.example.demo.api.model.TipoMoeda;

public interface TipoMoedaRepository extends JpaRepository<TipoMoeda, Long>{

	@Query(value = "select * from tipo_moeda ORDER BY nome" , nativeQuery = true)
	List<TipoMoeda> buscarAll();
}
