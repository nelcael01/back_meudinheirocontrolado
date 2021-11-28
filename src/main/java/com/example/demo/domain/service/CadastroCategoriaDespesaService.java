package com.example.demo.domain.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.CategoriaDespesa;

@Service
public class CadastroCategoriaDespesaService {
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void salvar(CategoriaDespesa categoriaDespesa) {
		entityManager.createNativeQuery(
			"INSERT INTO categoria_despesa ( id_categoria_despesa ,descricao) VALUES (?,?)")
	    	.setParameter(1, categoriaDespesa.getDescricao())  	
	    	.setParameter(2, categoriaDespesa.getId_categoria_despesa())
			.executeUpdate();
	}
}
