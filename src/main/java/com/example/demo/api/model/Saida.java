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
public class Saida {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue
	private Long id_saida;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private OffsetDateTime data;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(nullable = false, name="id_provento")
	private Provento provento;
	
	@ManyToOne
	@JoinColumn(nullable = false, name="id_categoria_despesa")
	private CategoriaDespesa categoriaDespesa;
	
	

}
