package br.edu.infnet.apiexame.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apiexame.model.domain.Fisico;

@Repository
public interface FisicoRepository extends CrudRepository<Fisico, Integer> {

	@Query("from Fisico f where f.usuario.id = :userid")
	List<Fisico> obterLista(Integer userid, Sort by);
}