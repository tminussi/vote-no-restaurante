package br.com.bluesoft.restaurante.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bluesoft.restaurante.service.RestauranteService;

@Controller
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView allRestaurants() {

		ModelAndView model = new ModelAndView("restaurante/restaurantes");
		model.addObject("restaurantes", restauranteService.findAll());

		return model;
	}

	@RequestMapping(value = "/ranking", method = RequestMethod.GET)
	public ModelAndView allRestaurantsByVotes(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("restaurante/rankingRestaurantes");
		model.addObject("topRestaurantes", restauranteService.findAllByVotos());
		model.addObject("votosUsuario", request.getAttribute("votosUsuario"));

		return model;
	}
}