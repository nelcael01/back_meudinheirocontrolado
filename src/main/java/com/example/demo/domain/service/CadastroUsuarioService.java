package com.example.demo.domain.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.Usuario;

@Service
public class CadastroUsuarioService{
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void salvar(Usuario usuario) {
		entityManager.createNativeQuery(
			"INSERT INTO usuario ( id_usuario, nome, senha, cpf, telefone, endereco) VALUES (?,?,?,?,?,?)")
	    	.setParameter(1, usuario.getId_usuario())  	
	    	.setParameter(2, usuario.getNome())
	    	.setParameter(3, usuario.getSenha())
			.setParameter(4, usuario.getCpf())
			.setParameter(5, usuario.getTelefone())
			.setParameter(6, usuario.getEndereco())
			.executeUpdate();
	}
	
	
}
