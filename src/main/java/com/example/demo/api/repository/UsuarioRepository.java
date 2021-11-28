package com.example.demo.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.api.model.Saida;
import com.example.demo.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//listar usuarios	
	@Query(value = "select * from Usuario ORDER BY nome" , nativeQuery = true)
	List<Usuario> buscarAll();
	
	//consulta para login			
	@Query(value = "select * from Usuario where nome = :nome and senha = :senha", nativeQuery = true)
	Usuario consultaLogin(@Param("nome")String nome, @Param("senha")String senha);
	
	//consulta para "esqueci minha senha"
	@Query(value="select * from Usuario where nome = :nome", nativeQuery = true)
	Usuario ConsultaNome(@Param("nome")String nome);
	
	//atualização de usuario			
	@Transactional
	@Modifying
	@Query(value="update Usuario u set u.senha = ? where u.nome = ?", nativeQuery = true)
	int atualizarUsuario(@Param("senha")String senha, @Param("nome")String nome);
	
	
	
}
