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
public class CategoriaDespesa {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue
	private Long id_categoria_despesa;	
	
	@Column(nullable = false)
	private String descricao;

	public Long getId_categoria_despesa() {
		return id_categoria_despesa;
	}

	public void setId_categoria_despesa(Long id_categoria_despesa) {
		this.id_categoria_despesa = id_categoria_despesa;
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
		result = prime * result + ((id_categoria_despesa == null) ? 0 : id_categoria_despesa.hashCode());
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
		CategoriaDespesa other = (CategoriaDespesa) obj;
		if (id_categoria_despesa == null) {
			if (other.id_categoria_despesa != null)
				return false;
		} else if (!id_categoria_despesa.equals(other.id_categoria_despesa))
			return false;
		return true;
	}
	
	

}
