package com.druiz.wikirap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.druiz.wikirap.entities.Artistas;
import com.druiz.wikirap.services.IArtistasService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestWikiController {
	class Respuesta {
		int code;
		String message;

		public Respuesta() {
		}

		public Respuesta(int code, String message) {
			super();
			this.code = code;
			this.message = message;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	@Autowired
	IArtistasService artistaService;

	// PETICIONES GET

	@GetMapping(path = "/artistas", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Artistas> getArtistas() {
		return artistaService.findAll();
	}

	@GetMapping(path = "/artista/findByNacionalidad", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Artistas> getArtistasByNacionalidad(
			@RequestParam(required = true, name = "nacionalidad") String nacionalidad) {
		return artistaService.findByNacionalidad(nacionalidad);
	}

	@GetMapping(path = "/artista/findByNombre", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Artistas> getArtistasByNombre
		(@RequestParam(required = true) String nombreartistico) {
		return artistaService.readByNombre(nombreartistico);
	}

	@GetMapping(path = "/artistas/findById", produces = { MediaType.APPLICATION_JSON_VALUE })
	Artistas getArtistasById(@RequestParam(required = true) Integer id) {
		return artistaService.readById(id);
	}

	//

	// PUT

	@PutMapping(path = "/artistas", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta updateArtista(
			@RequestParam(required = true) Integer id,
			@RequestParam(required = true) String nombreartistico,
			@RequestParam(required = true) String nombreNacimiento,
			@RequestParam(required = true) String imagen,
			@RequestParam(required = true) String fechaNacimiento, 
			@RequestParam(required = true) Integer edad,
			@RequestParam(required = true) String sexo,
			@RequestParam(required = true) String nacionalidad, 
			@RequestParam(required = true) String detalles) {
		try {
			artistaService.save(new Artistas(id, nombreartistico, nombreNacimiento, imagen, fechaNacimiento, edad,
					sexo,nacionalidad,detalles));
		} catch(Exception e) {
			return new Respuesta(-1, e.getMessage());
		}
		return new Respuesta(0, "Se ha actualizado correctamente el artista con nombre: " + nombreartistico + " y con la id: " + id);
	}
 
	// PETICIONES POST
	@PostMapping(path = "/artistas", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta addArtista(
			@RequestParam(required = true) String nombreartistico,
			@RequestParam(required = true) String nombrenacimiento, 
			@RequestParam(required = true) String imagen,
			@RequestParam(required = true) String fechanacimiento, 
			@RequestParam(required = true) Integer edad,
			@RequestParam(required = true) String sexo,
			@RequestParam(required = true) String nacionalidad, 
			@RequestParam(required = true) String detalles) {
		try {
			artistaService.save(new Artistas(0, nombreartistico, nombrenacimiento, imagen, fechanacimiento, edad,
					sexo,nacionalidad,detalles));
		} catch(Exception e) {
			return new Respuesta(-1, e.getMessage());
		}
		return new Respuesta(0, nombreartistico + " ha sido añadido correctamente!");
	}
	//

	@DeleteMapping(path = "/artistas", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta updateArtistas(@RequestParam(required = true) Integer id) {
		artistaService.delete(id);
		return new Respuesta(0, "Artista con id: " + id + " ha sido eliminado");
	}
}
