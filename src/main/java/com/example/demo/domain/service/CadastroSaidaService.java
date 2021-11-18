package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.Saida;
import com.example.demo.api.repository.CategoriaDespesaRepository;
import com.example.demo.api.repository.ProventoRepository;
import com.example.demo.api.repository.SaidaRepository;

@Service
public class CadastroSaidaService {
 
	@Autowired
	private SaidaRepository saidaRepository;
	
	@Autowired
	private ProventoRepository proventoRepository;
	
	@Autowired
	private CategoriaDespesaRepository categoriaDespesaRepository;
	
	
	
	public Saida salvar(Saida saida) {
		Long idProvento = saida.getProvento().getId_provento();
		saida.setProvento(proventoRepository.getById(idProvento));
		Long idCategoriaDespesa= saida.getCategoriaDespesa().getId_categoria_despesa();
		saida.setCategoriaDespesa(categoriaDespesaRepository.getById(idCategoriaDespesa));
		return saidaRepository.save(saida); 
		
	}
	
}
