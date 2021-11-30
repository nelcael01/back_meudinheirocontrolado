package com.example.demo.api.controller;

import java.util.ArrayList;
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
import com.example.demo.api.model.Saida;
import com.example.demo.api.repository.CategoriaDespesaRepository;
import com.example.demo.api.repository.ProventoRepository;
import com.example.demo.api.repository.SaidaRepository;
import com.example.demo.domain.service.CadastroSaidaService;

@RestController
@RequestMapping("/saidas")
public class SaidaController {
	@Autowired
	private SaidaRepository saidaRepository;
	
	@Autowired
	private CadastroSaidaService saidaService;
	
	@Autowired
	private ProventoRepository proventoRepository;
	
	@Autowired
	private CategoriaDespesaRepository categoriaDespesaRepository;
	
	@GetMapping("/{id}")
	public List<Saida> listar(@PathVariable Long id) {
		List<Provento> proventos = proventoRepository.buscarAll(id);
		List<Saida> saidasProvento = new ArrayList<>();
		if (proventos != null) {
			for (int i=0; i < proventos.size(); i++) {
				saidasProvento = saidaRepository.buscarAll(proventos.get(i).getId_provento()) ;
			}
			return  saidasProvento;
		}else {
			return null;
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody Saida saida) {
		Long idProvento = saida.getProvento().getId_provento();
		saida.setProvento(proventoRepository.buscarPorId(idProvento));
		Long idCategoriaDespesa= saida.getCategoriaDespesa().getId_categoria_despesa();
		saida.setCategoriaDespesa(categoriaDespesaRepository.getById(idCategoriaDespesa));
		saidaService.salvar(saida);
	}
	
	
	@PutMapping("/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Saida saida) {
		Saida saidaBuscada = saidaRepository.buscarPorId(id);
		BeanUtils.copyProperties(saida, saidaBuscada, "id_saida", "data");
		saidaRepository.atualizarSaida(
				saidaBuscada.getDescricao(),
				saidaBuscada.getValor(), 
				saidaBuscada.getProvento().getId_provento(), 
				saidaBuscada.getCategoriaDespesa().getId_categoria_despesa(), 
				saidaBuscada.getId_saida());
	}
	
	@DeleteMapping("{id}")
	public void remover(@PathVariable Long id) {
		saidaRepository.deletar(id);
	}
}
