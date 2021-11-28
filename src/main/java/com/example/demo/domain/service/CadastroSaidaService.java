package com.example.demo.domain.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.Saida;

@Service
public class CadastroSaidaService {
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void salvar(Saida saida) {
		entityManager.createNativeQuery(
			"INSERT INTO saida ( id_saida, data, descricao, valor, id_provento, id_categoria_despesa) VALUES (?,?,?,?,?,?)")
	    	.setParameter(1, saida.getId_saida())  	
	    	.setParameter(2, saida.getData().now())
	    	.setParameter(3, saida.getDescricao())
			.setParameter(4, saida.getValor())
			.setParameter(5, saida.getProvento().getId_provento())
			.setParameter(6, saida.getCategoriaDespesa().getId_categoria_despesa())
			.executeUpdate();
	}
	
}
