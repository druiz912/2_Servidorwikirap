package com.druiz.wikirap.repos;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.druiz.wikirap.entities.Discos;

@EnableJpaRepositories
@Repository
public interface IDiscosRepo extends JpaRepository<Discos, Integer> {
	
	@Query(nativeQuery = true, value = "select * from t_discos where autor like %:autor%")
	List<Discos> findByAutor(String autor);

	@Query(nativeQuery = true, value = "select * from t_discos where titulo like %:titulo%")
	List<Discos> readByNombre(String titulo);
	
	@Query(nativeQuery = true, value = "select * from t_discos limit :initial,:offset")
	List<Discos> getDiscosRange(int initial, int offset);
	
	@Query(nativeQuery = true,value="select count(*) from t_discos")
	Integer getNumberOfDiscos();

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="delete from t_discos where id>101")
	void clear();
}
