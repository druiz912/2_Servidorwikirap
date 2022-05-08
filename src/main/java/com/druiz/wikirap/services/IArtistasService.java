package com.druiz.wikirap.services;

import java.util.List;

import com.druiz.wikirap.entities.Artistas;

public interface IArtistasService {
	public void create(Artistas artista);

	public List<Artistas> findAll();

	public List<Artistas> findByNacionalidad(String nacionalidad);
	
	public List<Artistas> findBySexo(String sexo);

	public Artistas readById(Integer id);

	public List<Artistas> readByNombre(String nombreartistico);

	public void save(Artistas v) throws Exception;

	public void update(Artistas artist);

	public void delete(int identificador);

	public void clear();

	public Integer getNumberOfPages(int artistasByPage);

	/**
	 * Obtiene un conjunto de registros dada una posición y un offset.
	 * 
	 * @param initial Primer registro (el primero es 0)
	 * @param offset  Número de registros
	 * @return Listado de artistas
	 */
	public List<Artistas> readRange(int initial, int offset);

	
}
