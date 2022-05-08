package com.druiz.wikirap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.druiz.wikirap.entities.Artistas;
import com.druiz.wikirap.repos.IArtistasRepo;
import com.druiz.wikirap.services.IArtistasService;

import java.util.List;


@SpringBootTest
class WikiRapApplicationTests {

	@Autowired
	IArtistasRepo artistaRepo;
	@Autowired
	IArtistasService artistaService;
	
	
	void findAllArtistas() {
		List<Artistas> artista = artistaRepo.findAll();	
		for (Artistas artist : artista) {
			System.out.println(artist.getNombreartistico());
		}
	}
	
	
	void findAllArtistasServicio() {
		List<Artistas> artistas = artistaService.findAll();	
		for (Artistas artist : artistas) {
			System.out.println(artist.getNombreartistico());
		}
	}
	
	void findAllArtistasServicioByNacionalidad() {
		List<Artistas> artistas = artistaService.findByNacionalidad("Estadounidense");	
		for (Artistas artist : artistas) {
			System.out.println(artist.getNombreartistico());
		}
	}
	
	@Test
	void readByNombre() {
		List<Artistas> artistas = artistaService.readByNombre("Nas");	
		for (Artistas artist : artistas) {
			System.out.println(artist.getNombreartistico());
		}
	}
}
