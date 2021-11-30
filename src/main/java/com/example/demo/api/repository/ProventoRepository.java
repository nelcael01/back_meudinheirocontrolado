package com.example.demo.api.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.Provento;

public interface ProventoRepository extends JpaRepository<Provento, Long>{
	
	
	@Query(value = "select * from Provento where id_usuario = :id_usuario ORDER BY valor DESC" , nativeQuery = true)
	List<Provento> buscarAll(@Param("id_usuario")Long id_usuario);
	
	@Query(value = "select * from Provento p where p.id_provento = ?", nativeQuery = true)
	Provento buscarPorId(@Param("id_provento")Long id_provento );
	
	@Transactional
	@Modifying
	@Query(value = 
	"update Provento p set p.valor = ?, p.id_usuario= ?, p.id_tipo_entrada=?, p.id_tipo_moeda=? where p.id_provento=? ", nativeQuery = true)
	int atualizarProvento(
			@Param("valor") BigDecimal valor, 
			@Param("id_usuario") Long id_usuario,
			@Param("id_tipo_entrada") Long id_tipo_entrada, 
			@Param("id_tipo_moeda") Long id_tipo_moeda, 
			@Param("id_provento") Long id_provento
	);
	
	@Transactional
	@Modifying
	@Query(value = "delete from provento where id_provento = :id_provento", nativeQuery = true)
	void deletar(@Param("id_provento") Long id_provento);
	
	
}
