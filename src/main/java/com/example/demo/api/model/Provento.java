package com.example.demo.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Provento {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 
	
	
	public Long getId_provento() {
		return id_provento;
	}

	public void setId_provento(Long id_provento) {
		this.id_provento = id_provento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public OffsetDateTime getData() {
		return data;
	}

	public void setData(OffsetDateTime data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoEntrada getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(TipoEntrada tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public TipoMoeda getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(TipoMoeda tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_provento == null) ? 0 : id_provento.hashCode());
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
		Provento other = (Provento) obj;
		if (id_provento == null) {
			if (other.id_provento != null)
				return false;
		} else if (!id_provento.equals(other.id_provento))
			return false;
		return true;
	}
	
	
	

	
}
