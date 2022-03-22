 package br.edu.infnet.appconsulta.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appconsulta.model.domain.Laboratorial;

@Repository
public interface LaboratorialRepository extends CrudRepository<Laboratorial, Integer>{

	@Query("from Laboratorial l where l.usuario.id = :userid")
	List<Laboratorial> findAll(Integer userid, Sort by);
	
	List<Laboratorial> findAll(Sort by);
}
