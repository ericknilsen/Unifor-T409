package br.unifor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Disciplina;

@Stateless
public class DisciplinaDAO {

	@PersistenceContext
	private EntityManager manager;

	public String inserir(Disciplina disciplina) {

		try {
			manager.persist(disciplina);
			return "Disciplina "+disciplina.getCodigo()+" - "+disciplina.getNome()+" inserida.";
		} catch (PersistenceException e) {
			return "Erro ao inserir os dados" + e;
		}

	}

	public List<Disciplina> listar() {
				
		return manager.createQuery("SELECT d FROM Disciplina d ORDER BY d.nome").getResultList();
	}

}
