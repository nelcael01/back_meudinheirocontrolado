package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.Saida;
import com.example.demo.api.repository.SaidaRepository;
import com.example.demo.domain.service.CadastroSaidaService;

@RestController
@RequestMapping("/saidas")
public class SaidaController {
	@Autowired
	private SaidaRepository saidaRepository;
	
	@Autowired
	private CadastroSaidaService saidaService;
	
	@GetMapping
	public List<Saida> listar() {
		return saidaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody Saida saida) {
		saidaService.salvar(saida);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Saida saida) {
		Saida saidaBuscada = saidaRepository.getById(id);
		BeanUtils.copyProperties(saida, saidaBuscada, "id_saida", "data");
		saidaService.salvar(saidaBuscada);
	}
	
	@DeleteMapping("{id}")
	public void remover(@PathVariable Long id) {
		saidaService.remover(id);
	}
}
