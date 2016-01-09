package br.com.bluesoft.restaurante.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.bluesoft.restaurante.model.Restaurante;
import br.com.bluesoft.restaurante.repository.RestauranteRepository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

	private static final Logger LOGGER = Logger.getLogger(RestauranteRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Restaurante> findAll() {
		try {

			String hql = "SELECT r FROM Restaurante r";
			TypedQuery<Restaurante> query = this.entityManager.createQuery(hql, Restaurante.class);
			return query.getResultList();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<Restaurante> findAllByVotos() {
		try {

			String hql = "SELECT r FROM Restaurante r ORDER BY r.votos DESC";
			TypedQuery<Restaurante> query = this.entityManager.createQuery(hql, Restaurante.class);
			return query.getResultList();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Restaurante findById(Long id) {
		try {

			String hql = "SELECT r FROM Restaurante r WHERE r.id = :id";
			TypedQuery<Restaurante> query = this.entityManager.createQuery(hql, Restaurante.class);
			query.setParameter("id", id);
			return query.getSingleResult();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public void save(List<Restaurante> restaurantes) {
		for (Restaurante restaurante : restaurantes) {
			try {
				entityManager.merge(restaurante);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}

	}
}