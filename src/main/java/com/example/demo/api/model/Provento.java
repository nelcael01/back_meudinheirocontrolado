package com.example.demo.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Provento {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue
	private Long id_provento;	
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private OffsetDateTime data;
	
	@ManyToOne
	@JoinColumn(nullable = false, name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(nullable = false, name="id_tipo_entrada")
	private TipoEntrada tipoEntrada;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "id_tipo_moeda")
	private TipoMoeda tipoMoeda;
	
	
	

	
}
