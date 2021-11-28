package com.example.demo.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.CategoriaDespesa;
import com.example.demo.api.model.Saida;

public interface CategoriaDespesaRepository extends JpaRepository<CategoriaDespesa, Long>{
	
	@Query(value = "select * from categoria_despesa ORDER BY descricao" , nativeQuery = true)
	List<CategoriaDespesa> buscarAll();
	
	@Query(value = "select * from categoria_despesa s where s.id_categoria_despesa = ?", nativeQuery = true)
	Saida buscarPorId(@Param("id_categoria_despesa")Long id_categoria_despesa );
	
	@Transactional
	@Modifying
	@Query(value = "update Saida s set s.descricao = ? where s.id_categoria_despesa=? ", nativeQuery = true)
	int atualizarCategoriaDespesa(
			@Param("descricao") String descricao,
			@Param("id_saida")Long id_categoria_despesa 
	);
	
	@Transactional
	@Modifying
	@Query(value = "delete from categoria_despesa where id_categoria_despesa = :id_categoria_despesa", nativeQuery = true)
	void deletar(@Param("id_categoria_despesa") Long id_categoria_despesa);
	
}
