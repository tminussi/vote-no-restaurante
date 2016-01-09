package br.com.bluesoft.restaurante.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.bluesoft.restaurante.model.Restaurante;

public class RestauranteServiceTest {

	List<Restaurante> restaurantesVotados = new ArrayList<>();

	@Before
	public void init() {
		criarRestaurantes();

		restaurantesVotados.addAll(criarRestaurantes());
	}

	private List<Restaurante> criarRestaurantes() {
		List<Restaurante> restaurantes = new ArrayList<>();
		Restaurante restauranteUm = new Restaurante();
		restauranteUm.setId(1L);
		restauranteUm.setNome("Outback");
		restauranteUm.setVotos(20);

		Restaurante restauranteDois = new Restaurante();
		restauranteDois.setId(2L);
		restauranteDois.setNome("Applebees");
		restauranteDois.setVotos(25);

		restaurantes.add(restauranteUm);
		restaurantes.add(restauranteDois);

		return restaurantes;

	}

	@Test
	public void addVotesDeveAdicionarVotosQuandoRestauranteJaFoiVotadoPortantoGetVotosDeveRetornarMaiorQue1() {
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1L);
		if (restaurantesVotados.contains(restaurante)) {
			for (Restaurante r : restaurantesVotados) {
				if (r.equals(restaurante)) {
					restaurante.setVotos(r.getVotos() + 1);
				}
			}
		}
		Assert.assertTrue(restaurante.getVotos() > 1);
	}

	@Test
	public void addVotesDeveAdicionarVotosQuandoRestauranteNaoFoiVotadoPortantoGetVotosDeveRetornarSomente1() {
		Restaurante restaurante = new Restaurante();
		restaurante.setId(3L);
		if (!restaurantesVotados.contains(restaurante)) {
			restaurante.setVotos(restaurante.getVotos() + 1);
		}
		Assert.assertEquals(1, restaurante.getVotos());
	}

}
