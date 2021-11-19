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

	public Long getId_tipo_entrada() {
		return id_tipo_entrada;
	}

	public void setId_tipo_entrada(Long id_tipo_entrada) {
		this.id_tipo_entrada = id_tipo_entrada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipo_entrada == null) ? 0 : id_tipo_entrada.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoEntrada other = (TipoEntrada) obj;
		if (id_tipo_entrada == null) {
			if (other.id_tipo_entrada != null)
				return false;
		} else if (!id_tipo_entrada.equals(other.id_tipo_entrada))
			return false;
		return true;
	}
	
 	
 	
}
