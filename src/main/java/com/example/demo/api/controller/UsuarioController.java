package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.VO.UsuarioVO;
import com.example.demo.api.model.Usuario;
import com.example.demo.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/buscaLogin")
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
	
}
