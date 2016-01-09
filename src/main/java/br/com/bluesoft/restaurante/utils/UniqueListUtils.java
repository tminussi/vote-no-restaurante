package br.com.bluesoft.restaurante.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.bluesoft.restaurante.model.Restaurante;

public class UniqueListUtils {

	public static final Set<Restaurante> uniqueList(List<Restaurante> restaurantes) {
		Set<Restaurante> restaurantesSet = new HashSet<>();
		for (Restaurante restaurante : restaurantes) {
			int totalVotosPorRestaurante = Collections.frequency(restaurantes, restaurante);
			restaurante.setVotos(totalVotosPorRestaurante);
			restaurantesSet.add(restaurante);
		}
		return restaurantesSet;
	}

}
