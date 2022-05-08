package com.druiz.wikirap.repos;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.druiz.wikirap.entities.Artistas;

@EnableJpaRepositories
@Repository
public interface IArtistasRepo extends JpaRepository<Artistas, Integer> {
	
	@Query(nativeQuery = true, value = "select * from t_artistas where nacionalidad like %:nacionalidad%")
	List<Artistas> findAllByNacionalidad(String nacionalidad);

	@Query(nativeQuery = true, value="select t from t_artistas t where nombre_artistico like %:nombreartistico%")
	List<Artistas> readByNombre(String nombreartistico); 
	
	@Query(nativeQuery = true, value = "select * from t_artistas limit :initial,:offset")
	List<Artistas> getArtistasRange(int initial, int offset);

	@Query(nativeQuery = true, value = "select * from t_artistas where sexo like %:sexo%")
	List<Artistas> findBySexo(String sexo);

	@Query(nativeQuery = true,value="select count(*) from t_artistas")
	Integer getNumberOfArtistas();
	

	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="delete from t_artistas where id>101")
	void clear();
	
	

	
	// @Query(value = "select * from artistas where u.status = 1", nativeQuery =
	// true)





}
