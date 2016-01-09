package br.com.bluesoft.restaurante.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.bluesoft.restaurante.repository.RestauranteRepository;
import br.com.bluesoft.restaurante.repository.UsuarioRepository;
import br.com.bluesoft.restaurante.service.RestauranteService;
import br.com.bluesoft.restaurante.service.UsuarioService;

@RunWith(MockitoJUnitRunner.class)
public class HsqlDBTest {

	@InjectMocks
	private RestauranteService restauranteService;

	@InjectMocks
	private UsuarioService usuarioService;

	@Mock
	private RestauranteRepository restauranteRepository;

	@Mock
	private UsuarioRepository usuarioRepository;

	/**
	 * Testa a conexão com o banco de dados embutido na aplicação realizando um
	 * SELECT
	 */
	@Test
	public void dbConnectionTest() {
		assertEquals(0, restauranteService.findAll().size());
	}

}
