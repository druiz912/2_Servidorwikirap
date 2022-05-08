package com.druiz.wikirap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.druiz.wikirap.entities.Artistas;
import com.druiz.wikirap.repos.IArtistasRepo;

@Service
public class ArtistasServiceImpl implements IArtistasService {
	
	final static int EDAD_MINIMA=16;

	@Autowired
	IArtistasRepo artistasRepo;

	@Override
	public List<Artistas> findAll() {
		List<Artistas> artistas = artistasRepo.findAll();
		return artistas;
	}

	@Override
	public List<Artistas> readByNombre(String nombreartistico){
		List<Artistas> artista = artistasRepo.readByNombre(nombreartistico);
		return artista;
	}

	@Override
	public List<Artistas> findByNacionalidad(String nacionalidad) {
		List<Artistas> artistas = artistasRepo.findAllByNacionalidad(nacionalidad);
		return artistas;
	}
	
	@Override
	public List<Artistas> findBySexo(String sexo) {
		List<Artistas> artistas = artistasRepo.findBySexo(sexo);
		return artistas;
	}

	@Override
	public void save(Artistas v) throws Exception {
		if (v.getEdad()<EDAD_MINIMA) {
			throw new Exception("La edad debe ser mayor de " + EDAD_MINIMA);
		}
		artistasRepo.save(v); 
	}

	@Override
	public void update(Artistas artista) {
		artistasRepo.save(artista);
	}

	@Override
	public void delete(int identificador) {
		artistasRepo.deleteById(identificador);	
	}

	@Override
	public void create(Artistas artista) {
		artistasRepo.save(artista);
	}

	@Override
	public Artistas readById(Integer id) {
		Artistas artista = artistasRepo.findById(id).get();
		return artista;
	}

	@Override
	public void clear() {
		artistasRepo.clear();
		
	}

	@Override
	public Integer getNumberOfPages(int artistasByPage) {
		Integer numberOfArtistas = artistasRepo.getNumberOfArtistas();
		float nop = (float)numberOfArtistas/(float)artistasByPage;
		return (int)Math.ceil(nop);
	}

	@Override
	public List<Artistas> readRange(int initial, int offset) {
		return artistasRepo.getArtistasRange(initial, offset);
	}

}
