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

	public Long getId_tipo_moeda() {
		return id_tipo_moeda;
	}

	public void setId_tipo_moeda(Long id_tipo_moeda) {
		this.id_tipo_moeda = id_tipo_moeda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipo_moeda == null) ? 0 : id_tipo_moeda.hashCode());
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
		TipoMoeda other = (TipoMoeda) obj;
		if (id_tipo_moeda == null) {
			if (other.id_tipo_moeda != null)
				return false;
		} else if (!id_tipo_moeda.equals(other.id_tipo_moeda))
			return false;
		return true;
	}
	
	

}
