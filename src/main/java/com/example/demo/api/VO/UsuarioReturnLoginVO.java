package com.example.demo.api.VO;

import org.springframework.stereotype.Component;

@Component
public class UsuarioReturnLoginVO {
	
	private boolean logado;
	
	private Long id_logado;
	
	private String nome;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public boolean getLogado() {
		return logado;
	}
	
	public void setId_logado(Long id_logado) {
		this.id_logado = id_logado;
	}
	
	public Long getId_logado() {
		return id_logado;
	}

	

	
}
