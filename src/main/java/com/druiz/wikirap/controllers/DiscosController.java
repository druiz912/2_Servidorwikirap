package com.druiz.wikirap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.druiz.wikirap.entities.Discos;
import com.druiz.wikirap.services.IDiscosService;

@Controller
public class DiscosController {

	@Autowired
	private IDiscosService discosService;
	
	@RequestMapping(value = "/addDiscos")
	public ModelAndView addDiscos( 
			@RequestParam(required = false) Integer id,
			@RequestParam(required = false) String portada,
			@RequestParam(required = false) String titulo,
			@RequestParam(required = false) String autor,
			@RequestParam(required = false) String duracion, 
			@RequestParam(required = false) String fechaSalida){
			if (titulo != null) {
				Discos disc = new Discos(0, portada, titulo, autor, duracion, fechaSalida);
				discosService.create(disc);
			}
			//Creamos el ModelAndView
			ModelAndView mav = new ModelAndView(); //Ahora ModelAndView es mav
			//Obtenemos la lista de peliculas
			List<Discos> disc = discosService.findAll();
			//Le damos nombre al ModelAndView
			mav.setViewName("crear_discos.html");
			mav.addObject("Discos", disc);
			return mav;
}
	
}
