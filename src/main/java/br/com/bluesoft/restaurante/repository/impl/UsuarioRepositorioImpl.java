package br.com.bluesoft.restaurante.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.bluesoft.restaurante.model.Usuario;
import br.com.bluesoft.restaurante.repository.UsuarioRepository;

@Repository
public class UsuarioRepositorioImpl implements UsuarioRepository {

	private static final Logger LOGGER = Logger.getLogger(UsuarioRepositorioImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Usuario usuario) {
		try {
			this.entityManager.merge(usuario);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<Usuario> findAll() {
		try {

			String hql = "SELECT u FROM Usuario u";
			TypedQuery<Usuario> query = this.entityManager.createQuery(hql, Usuario.class);
			return query.getResultList();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public Usuario findByEmail(String email) {
		try {

			String hql = "SELECT u FROM Usuario u WHERE u.email = :email";
			TypedQuery<Usuario> query = this.entityManager.createQuery(hql, Usuario.class);
			query.setParameter("email", email);
			return query.getSingleResult();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

}