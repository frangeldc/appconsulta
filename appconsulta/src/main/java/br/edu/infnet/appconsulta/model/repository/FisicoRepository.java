package br.edu.infnet.appconsulta.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appconsulta.model.domain.Fisico;

@Repository
public interface FisicoRepository extends CrudRepository<Fisico, Integer>{

	@Query("from Fisico f where f.usuario.id = :userid")
	List<Fisico> findAll(Integer userid, Sort by);
	
	List<Fisico> findAll(Sort by);
}
