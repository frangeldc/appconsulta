package br.edu.infnet.apimedico.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apimedico.model.domain.Medico;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer> {

	@Query("from Medico m where m.usuario.id = :userid")
	List<Medico> obterLista(Integer userid, Sort by);	
}