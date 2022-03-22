package br.edu.infnet.appconsulta.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appconsulta.model.domain.Consulta;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{
	
	@Query("from Consulta c where c.usuario.id = :userid")
	List<Consulta> findAll(Integer userid, Sort by);

	List<Consulta> findAll(Sort by);
}
