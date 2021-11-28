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

import com.example.demo.api.model.Provento;
import com.example.demo.api.repository.ProventoRepository;
import com.example.demo.domain.service.CadastroProventoService;


@RestController
@RequestMapping("/proventos")
public class ProventoController {
	
	@Autowired
	private ProventoRepository proventoRepository;
	
	@Autowired
	private CadastroProventoService proventoService;
	
	@GetMapping
	public List<Provento> listar() {
		return proventoRepository.buscarAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody Provento provento) {
		proventoService.salvar(provento);
	}
	
	@PutMapping("{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Provento provento) {
		Provento proventoBuscado = proventoRepository.buscarPorId(id);
		BeanUtils.copyProperties(provento, proventoBuscado, "id_provento", "data");
		proventoRepository.atualizarProvento(
				proventoBuscado.getValor(),
				proventoBuscado.getUsuario().getId_usuario(),
				proventoBuscado.getTipoEntrada().getId_tipo_entrada(),
				proventoBuscado.getTipoMoeda().getId_tipo_moeda(),
				proventoBuscado.getId_provento()
		);
	}
	
	@DeleteMapping("{id}")
	public void remover(@PathVariable Long id) {
		proventoRepository.deletar(id);
	}
	
}
