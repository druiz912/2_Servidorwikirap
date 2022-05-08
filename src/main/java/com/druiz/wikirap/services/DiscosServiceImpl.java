package com.druiz.wikirap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.druiz.wikirap.entities.Discos;
import com.druiz.wikirap.repos.IDiscosRepo;

@Service
public class DiscosServiceImpl implements IDiscosService {
	

	@Autowired
	IDiscosRepo discosRepo;

	@Override
	public List<Discos> findAll() {
		List<Discos> discos = discosRepo.findAll();
		return discos;
	}

	@Override
	public List<Discos> readByNombre(String titulo){
		List<Discos> discos= discosRepo.readByNombre(titulo);
		return discos;
	}

	@Override
	public List<Discos> findByAutor(String autor) {
		List<Discos> discos = discosRepo.findByAutor(autor);
		return discos;
	}

	@Override
	public void update(Discos discos) {
		discosRepo.save(discos);
	}

	@Override
	public void delete(int identificador) {
		discosRepo.deleteById(identificador);	
	}

	@Override
	public void create(Discos discos) {
		discosRepo.save(discos);
	}

	@Override
	public Discos readById(Integer id) {
		Discos discos = discosRepo.findById(id).get();
		return discos;
	}

	@Override
	public void clear() {
		discosRepo.clear();
	}

	@Override
	public Integer getNumberOfPages(int discosByPage) {
		Integer numberOfDiscos= discosRepo.getNumberOfDiscos();
		float nop = (float)numberOfDiscos/(float)discosByPage;
		return (int)Math.ceil(nop);
	}

	@Override
	public List<Discos> readRange(int initial, int offset) {
		return discosRepo.getDiscosRange(initial, offset);
	}

	@Override
	public void save(Discos discos) {
		discosRepo.save(discos);
		
	}

}
