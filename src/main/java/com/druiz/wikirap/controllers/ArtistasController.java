package com.druiz.wikirap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.druiz.wikirap.entities.Artistas;
import com.druiz.wikirap.services.IArtistasService;

@Controller
public class ArtistasController {

	@Autowired
	private IArtistasService artistasService;
	
	@RequestMapping(value = "/addArtista")
	public ModelAndView addArtista( 
	@RequestParam(required = false) Integer id,
	@RequestParam(required = false) String nombreartistico,
	@RequestParam(required = false) String nombreNacimiento,
	@RequestParam(required = false) String imagen,
	@RequestParam(required = false) String fechaNacimiento, 
	@RequestParam(required = false) Integer edad,
	@RequestParam(required = false) String sexo,
	@RequestParam(required = false) String nacionalidad, 
	@RequestParam(required = false) String detalles) {
			if (nombreartistico != null) {
				Artistas art = new Artistas(0, nombreartistico, nombreNacimiento, imagen, fechaNacimiento, edad
						,sexo,nacionalidad,detalles );
				artistasService.create(art);
			}
			//Creamos el ModelAndView
			ModelAndView mav = new ModelAndView(); //Ahora ModelAndView es mav
			//Obtenemos la lista de peliculas
			List<Artistas> artist = artistasService.findAll();
			//Le damos nombre al ModelAndView
			mav.setViewName("crear_artista.html");
			mav.addObject("Artistas", artist);
			return mav;
}
	
}
