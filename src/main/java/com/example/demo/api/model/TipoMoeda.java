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
public class TipoMoeda {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue
	private Long id_tipo_moeda;	
	
	@Column(nullable = false)
	private String nome;

}
