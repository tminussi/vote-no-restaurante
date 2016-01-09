package br.com.bluesoft.restaurante.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RestauranteTest {

	@Test
	public void testEqualObjects() {
		Restaurante restauranteUm = new Restaurante();
		Restaurante restauranteDois = new Restaurante();
		restauranteUm.setId(1L);
		restauranteDois.setId(1L);
		assertEquals(restauranteUm, restauranteDois);
	}

}
