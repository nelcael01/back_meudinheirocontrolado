package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.Provento;
import com.example.demo.api.model.Usuario;
import com.example.demo.api.repository.ProventoRepository;
import com.example.demo.api.repository.TipoEntradaRepository;
import com.example.demo.api.repository.TipoMoedaRepository;
import com.example.demo.api.repository.UsuarioRepository;

@Service
public class CadastroProventoService {
	@Autowired
	private ProventoRepository proventoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoEntradaRepository tipoEntradaRepository;
	
	@Autowired
	private TipoMoedaRepository tipoMoedaRepository;
	
	public Provento salvar(Provento provento) {
		Long idUsuario = provento.getUsuario().getId_usuario();
		provento.setUsuario(usuarioRepository.getById(idUsuario));
		Long idTipoEntrada = provento.getTipoEntrada().getId_tipo_entrada();
		provento.setTipoEntrada(tipoEntradaRepository.getById(idTipoEntrada));
		Long idTipoMoeda = provento.getTipoMoeda().getId_tipo_moeda();
		provento.setTipoMoeda(tipoMoedaRepository.getById(idTipoMoeda));
		return proventoRepository.save(provento);
	}
	
	
}





//@ManyToOne
//@JoinColumn(nullable = false, name="id_usuario")
//private Usuario usuario;
//
//@ManyToOne
//@JoinColumn(nullable = false, name="id_tipo_entrada")
//private TipoEntrada tipoEntrada;
//
//@ManyToOne
//@JoinColumn(nullable = false, name = "id_tipo_moeda")
//private TipoMoeda tipoMoeda;