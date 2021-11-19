package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.CategoriaDespesa;
import com.example.demo.api.repository.CategoriaDespesaRepository;

@RestController
@RequestMapping("/categoriaDespesa")
public class CategoriaDespesaController {
	@Autowired
	private CategoriaDespesaRepository categoriaRepository;
	
	@GetMapping
	public List<CategoriaDespesa> listar() {
		return categoriaRepository.findAll();
	}
	
}
