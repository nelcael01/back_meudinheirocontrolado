package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.TipoMoeda;
import com.example.demo.api.repository.TipoMoedaRepository;

@RestController
@RequestMapping("/tipoMoeda")
public class TipoMoedaController {
	
	@Autowired
	private TipoMoedaRepository tipoMoedaRepository;
	
	@GetMapping
	public List<TipoMoeda> listar() {
		return tipoMoedaRepository.findAll();
	}

}
