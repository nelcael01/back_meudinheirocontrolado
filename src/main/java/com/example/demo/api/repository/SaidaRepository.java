package com.example.demo.api.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.Saida;

public interface SaidaRepository extends JpaRepository<Saida, Long>{
	
	
	@Query(value = "select * from Saida where id_provento = :id_provento ORDER BY valor DESC" , nativeQuery = true)
	List<Saida> buscarAll(@Param("id_provento")Long id_provento);
	
	@Query(value = "select * from Saida s where s.id_saida = ?", nativeQuery = true)
	Saida buscarPorId(@Param("id_saida")Long id_saida );
	
	@Transactional
	@Modifying
	@Query(value = "update Saida s set s.descricao = ?, s.valor = ?, s.id_provento=?, s.id_categoria_despesa=? where s.id_saida=? ", nativeQuery = true)
	int atualizarSaida(
			@Param("descricao") String descricao,
			@Param("valor") BigDecimal valor, 
			@Param("id_provento") Long id_provento, 
			@Param("id_categoria_despesa") Long id_categoria_despesa, 
			@Param("id_saida")Long id_saida 
	);
	
	@Transactional
	@Modifying
	@Query(value = "delete from saida where id_saida = :id_saida", nativeQuery = true)
	void deletar(@Param("id_saida") Long id_saida);
	
	
}




