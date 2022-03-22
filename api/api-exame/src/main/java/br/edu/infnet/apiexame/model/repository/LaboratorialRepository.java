package br.edu.infnet.apiexame.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apiexame.model.domain.Laboratorial;

@Repository
public interface LaboratorialRepository extends CrudRepository<Laboratorial, Integer> {

	@Query("from Laboratorial l where l.usuario.id = :userid")
	List<Laboratorial> obterLista(Integer userid, Sort by);
}