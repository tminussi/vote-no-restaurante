package br.com.bluesoft.restaurante.repository;

import java.util.List;

import br.com.bluesoft.restaurante.model.Restaurante;

public interface RestauranteRepository {

	public List<Restaurante> findAll();

	public List<Restaurante> findAllByVotos();

	public Restaurante findById(Long id);

	public void save(List<Restaurante> restaurante);
}
