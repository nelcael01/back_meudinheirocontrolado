package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.TipoEntrada;
import com.example.demo.api.repository.TipoEntradaRepository;

@RestController
@RequestMapping("/tipoEntrada")
public class TipoEntradaController {

	@Autowired
	private TipoEntradaRepository tipoEntradaRepository;
	
	@GetMapping
	public List<TipoEntrada> listar() {
		return tipoEntradaRepository.buscarAll();
	}

}
