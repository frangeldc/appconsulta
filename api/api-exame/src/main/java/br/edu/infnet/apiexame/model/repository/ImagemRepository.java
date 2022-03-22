package br.edu.infnet.apiexame.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apiexame.model.domain.Imagem;

@Repository
public interface ImagemRepository extends CrudRepository<Imagem, Integer> {

	@Query("from Imagem i where i.usuario.id = :userid")
	List<Imagem> obterLista(Integer userid, Sort by);
}