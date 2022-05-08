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
import com.druiz.wikirap.entities.Discos;
import com.druiz.wikirap.services.IDiscosService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestWikiDiscosController {
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
	IDiscosService discosService;

	// PETICIONES GET

	@GetMapping(path = "/discos", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Discos> getDiscos() {
		return discosService.findAll();
	}

	@GetMapping(path = "/discos/findByAutor", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Discos> getDiscosByAutor(
			@RequestParam(required = true, name = "autor") String autor) {
		return discosService.findByAutor(autor);
	}

	@GetMapping(path = "/discos/findByNombre", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Discos> getDiscosByNombre
		(@RequestParam(required = true) String titulo) {
		return discosService.readByNombre(titulo);
	}

	@GetMapping(path = "/discos/findById", produces = { MediaType.APPLICATION_JSON_VALUE })
	Discos getDiscosById(@RequestParam(required = true) Integer id) {
		return discosService.readById(id);
	}

	//

	// PUT

	@PutMapping(path = "/discos", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta updateDiscos(
			@RequestParam(required = true) Integer id,
			@RequestParam(required = true) String portada,
			@RequestParam(required = true) String titulo,
			@RequestParam(required = true) String autor,
			@RequestParam(required = true) String duracion, 
			@RequestParam(required = true) String fechaSalida) {
		try {
			discosService.save(new Discos(id, portada, titulo, autor, duracion, fechaSalida));
		} catch(Exception e) {
			return new Respuesta(-1, e.getMessage());
		}
		return new Respuesta(0, "Se ha actualizado correctamente el disco con nombre: " + titulo + " autor/a: " + autor  + " y con la id: " + id);
	}
 
	// PETICIONES POST
	@PostMapping(path = "/discos", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta addDiscos(
			@RequestParam(required = false) Integer id,
			@RequestParam(required = true) String portada,
			@RequestParam(required = true) String titulo,
			@RequestParam(required = true) String autor,
			@RequestParam(required = true) String duracion, 
			@RequestParam(required = true) String fechaSalida) {
		try {
			discosService.save(new Discos(0, portada, titulo, autor, duracion, fechaSalida));
		} catch(Exception e) {
			return new Respuesta(-1, e.getMessage());
		}
		return new Respuesta(0, titulo + " ha sido añadido correctamente!");
	}
	//

	@DeleteMapping(path = "/discos", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta updateArtistas(@RequestParam(required = true) Integer id) {
		discosService.delete(id);
		return new Respuesta(0, "Disco con id: " + id + " ha sido eliminado");
	}
}
