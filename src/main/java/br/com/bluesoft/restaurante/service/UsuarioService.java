package br.com.bluesoft.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluesoft.restaurante.model.Usuario;
import br.com.bluesoft.restaurante.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository userRepository;

	@Transactional
	public void save(Usuario usuario) {
		this.userRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return userRepository.findAll();
	}

	public Usuario findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}