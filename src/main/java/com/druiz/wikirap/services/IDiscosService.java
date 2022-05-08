package com.druiz.wikirap.services;

import java.util.List;
import com.druiz.wikirap.entities.Discos;

public interface IDiscosService {
	

	public List<Discos> findAll();
	
	public List<Discos> readByNombre(String titulo);

	public List<Discos> findByAutor(String autor);
	
	public void update(Discos discos);
	
	public void delete(int identificador);
	
	public void create(Discos discos);

	public Discos readById(Integer id);

	public void clear();

	public Integer getNumberOfPages(int discosByPage);

	/**
	 * Obtiene un conjunto de registros dada una posición y un offset.
	 * 
	 * @param initial Primer registro (el primero es 0)
	 * @param offset  Número de registros
	 * @return Listado de artistas
	 */
	public List<Discos> readRange(int initial, int offset);

	public void save(Discos discos);

	
}
