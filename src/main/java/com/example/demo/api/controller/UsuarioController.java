package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.api.VO.UsuarioVO;
import com.example.demo.api.model.Usuario;
import com.example.demo.api.repository.UsuarioRepository;
import com.example.demo.domain.service.CadastroUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CadastroUsuarioService usuarioService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
	}
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.buscarAll();
	}
	
	@PostMapping("/buscaLogin")
	public boolean buscaLogin(@RequestBody UsuarioVO usuarioVO) {
		try {
			Usuario usuario = usuarioRepository.consultaLogin(usuarioVO.getNome(),usuarioVO.getSenha());
			if (usuario.getId_usuario() != null) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@PutMapping("/atualizarUsuario")
	public boolean atualizarUsuario(@RequestBody UsuarioVO usuarioVO) {
		try {
			Usuario usuarioBuscado = usuarioRepository.ConsultaNome(usuarioVO.getNome());
			if (usuarioBuscado.getId_usuario() != null) {
				int linhas = usuarioRepository.atualizarUsuario(usuarioVO.getSenha(), usuarioBuscado.getNome());
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
}
