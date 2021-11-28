package com.example.demo.domain.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.Provento;

@Service
public class CadastroProventoService {
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(Provento provento) {
		entityManager.createNativeQuery(
			"INSERT INTO provento ( id_provento, data, valor, id_usuario, id_tipo_entrada, id_tipo_moeda) VALUES (?,?,?,?,?,?)")
	    	.setParameter(1, provento.getId_provento())  	
	    	.setParameter(2, provento.getData().now())
	    	.setParameter(3, provento.getValor())
			.setParameter(4, provento.getUsuario().getId_usuario())
			.setParameter(5, provento.getTipoEntrada().getId_tipo_entrada())
			.setParameter(6, provento.getTipoMoeda().getId_tipo_moeda())
			.executeUpdate();
	}
	
	
}