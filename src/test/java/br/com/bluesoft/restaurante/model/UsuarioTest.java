package br.com.bluesoft.restaurante.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void testEqualObjects() {
		Usuario usuarioUm = new Usuario();
		Usuario usuarioDois = new Usuario();
		usuarioUm.setId(1L);
		usuarioDois.setId(1L);
		assertEquals(usuarioUm, usuarioDois);
	}

}
