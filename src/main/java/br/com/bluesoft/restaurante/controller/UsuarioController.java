package br.com.bluesoft.restaurante.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bluesoft.restaurante.model.Restaurante;
import br.com.bluesoft.restaurante.model.Usuario;
import br.com.bluesoft.restaurante.service.RestauranteService;
import br.com.bluesoft.restaurante.service.UsuarioService;
import br.com.bluesoft.restaurante.utils.UniqueListUtils;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	public static final String OBRIGADO = "Obrigado por participar!";

	public static final String JA_PARTICIPOU = "Voc\u00ea j\u00e1 participou desta vota\u00e7\u00e3o";

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RestauranteService restauranteService;

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView newUser() {
		Usuario user = new Usuario();
		ModelAndView model = new ModelAndView("usuarios/novoUsuario");
		model.addObject("novoUsuario", user);
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView saveUser(Usuario usuario, RedirectAttributes redirectAttributes, HttpServletRequest request) throws ParseException {
		List<Restaurante> restaurantesVotados = (ArrayList<Restaurante>) request.getSession().getAttribute("restaurantesVotados");
		if (usuarioService.findByEmail(usuario.getEmail()) == null) {
			restauranteService.save(restaurantesVotados);
			usuarioService.save(usuario);
			request.getSession().setAttribute("votosUsuario", UniqueListUtils.uniqueList(restaurantesVotados));
			redirectAttributes.addFlashAttribute("obrigado", OBRIGADO);
			return new ModelAndView("redirect:/restaurantes/ranking");
		}
		redirectAttributes.addFlashAttribute("participou", JA_PARTICIPOU);
		request.getSession().removeAttribute("votosUsuario");
		return new ModelAndView("redirect:/restaurantes/ranking");
	}
}