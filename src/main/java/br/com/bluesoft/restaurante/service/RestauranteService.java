package br.com.bluesoft.restaurante.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.restaurante.model.Restaurante;
import br.com.bluesoft.restaurante.repository.RestauranteRepository;
import br.com.bluesoft.restaurante.utils.Match;

@Service
public class RestauranteService {

	private List<Restaurante> restaurantes;
	private List<Restaurante> restaurantesDaRodada = new ArrayList<Restaurante>();
	private List<Match> matches = new ArrayList<Match>();
	private Long listIndexSideA = 0L;
	private Long listIndexSideB = 1L;
	private List<Restaurante> restaurantesVotados = new ArrayList<Restaurante>();

	private static final int VOTOS_MAXIMOS = 10;

	private static final int INCREMENTA_UM_VOTO = 1;

	@Autowired
	private RestauranteRepository restauranteRepository;

	public List<Restaurante> findAll() {
		return this.restauranteRepository.findAll();
	}

	public List<Restaurante> findAllForBattle(Long idEscolhido, HttpServletRequest request) {
		if (idEscolhido == null) {
			restaurantesVotados.clear();
			restaurantes = restauranteRepository.findAll();

			restaurantesDaRodada.clear();
			matches.clear();
			listIndexSideA = 0L;
			listIndexSideB = 1L;
			restaurantesDaRodada.add(restaurantes.get(listIndexSideA.intValue()));
			restaurantesDaRodada.add(restaurantes.get(listIndexSideB.intValue()));

			return this.restaurantesDaRodada;
		}
		computeVote(idEscolhido);
		restaurantesDaRodada.clear();

		Match match = new Match(listIndexSideA.intValue(), listIndexSideB.intValue());
		matches.add(match);

		if (listIndexSideA.intValue() < restaurantes.size() - 1) {
			if (listIndexSideB.intValue() < restaurantes.size() - 1) {
				listIndexSideB++;
			} else {
				listIndexSideB = 0L;
				listIndexSideA++;
			}

			while (!validateMatch(listIndexSideA.intValue(), listIndexSideB.intValue())) {
				listIndexSideB++;
			}

			if (listIndexSideA.intValue() >= restaurantes.size() - 1 && listIndexSideB.intValue() >= restaurantes.size() - 1) {
				return null;
			}

			restaurantesDaRodada.add(restaurantes.get(listIndexSideA.intValue()));
			restaurantesDaRodada.add(restaurantes.get(listIndexSideB.intValue()));

			request.getSession().setAttribute("restaurantesVotados", restaurantesVotados);
			return this.restaurantesDaRodada;
		}

		return new ArrayList<>();

	}

	public List<Restaurante> findAllByVotos() {
		return this.restauranteRepository.findAllByVotos();
	}

	@Transactional
	public void save(List<Restaurante> restaurantes) {
		restauranteRepository.save(restaurantesVotados);
	}

	private Restaurante findById(Long id) {
		return this.restauranteRepository.findById(id);
	}

	private void computeVote(Long id) {
		if (restaurantesVotados.size() == VOTOS_MAXIMOS) {
			restaurantesVotados.clear();
		}
		Restaurante restaurante = findById(id);
		addVotes(id, restaurante);
		restaurantesVotados.add(restaurante);

	}

	private void addVotes(Long id, Restaurante restaurante) {
		if (restaurantesVotados.contains(restaurante)) {
			for (Restaurante r : restaurantesVotados) {
				if (r.getId().equals(id)) {
					restaurante.setVotos(r.getVotos() + INCREMENTA_UM_VOTO);
				}
			}
		} else {
			restaurante.setVotos(restaurante.getVotos() + INCREMENTA_UM_VOTO);
		}
	}

	private boolean validateMatch(int sideA, int sideB) {
		if (sideA == sideB) {
			return false;
		}

		for (Match m : matches) {
			if (m.getSideA() == sideB) {
				if (m.getSideB() == sideA) {
					return false;
				}
			}
			if (m.getSideB() == sideB) {
				if (m.getSideA() == sideA) {
					return false;
				}
			}
		}

		return true;
	}

}