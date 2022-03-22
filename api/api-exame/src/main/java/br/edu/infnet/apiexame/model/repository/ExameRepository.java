package br.edu.infnet.apiexame.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apiexame.model.domain.Exame;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Integer> {

	@Query("from Exame e where e.usuario.id = :userid")
	List<Exame> obterLista(Integer userid, Sort by);
}