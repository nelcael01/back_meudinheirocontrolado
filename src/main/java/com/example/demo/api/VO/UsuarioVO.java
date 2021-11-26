package com.example.demo.api.VO;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UsuarioVO {
	
	private String senha;
	
	private String nome;
	
}
