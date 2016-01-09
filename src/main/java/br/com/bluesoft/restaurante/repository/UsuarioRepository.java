package br.com.bluesoft.restaurante.repository;

import java.util.List;

import br.com.bluesoft.restaurante.model.Usuario;

public interface UsuarioRepository {

	public void save(Usuario usuario);

	public List<Usuario> findAll();

	public Usuario findByEmail(String email);

}