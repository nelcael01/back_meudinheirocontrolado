package com.example.demo.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue
	private Long id_usuario;	
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String endereco;
	
//	@OneToMany
//	private List<Provento> proventos;
	
}
