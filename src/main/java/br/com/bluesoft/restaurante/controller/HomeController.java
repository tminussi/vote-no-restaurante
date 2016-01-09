package br.com.bluesoft.restaurante.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.bluesoft.restaurante.service.RestauranteService;

@Controller
public class HomeController {

	private static final String TESTE_INICIADO = "Teste Iniciado";

	@Autowired
	private RestauranteService restauranteService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("restaurante/dueloRestaurantes");
		model.addObject("restaurantes", this.restauranteService.findAllForBattle(null, null));
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView restaurantBattle(@RequestParam(value = "restauranteID", required = false) Long restauranteID, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("restaurante/dueloRestaurantes");
		model.addObject("testeIniciado", TESTE_INICIADO);
		model.addObject("restaurantes", this.restauranteService.findAllForBattle(restauranteID, request));
		return model;
	}
}