package com.example.demo.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoEntrada {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue
	private Long id_tipo_entrada;	
	
	@Column(nullable = false)
	private String nome;
	
 	@Column(nullable = false)
	private String descricao;
	

}
