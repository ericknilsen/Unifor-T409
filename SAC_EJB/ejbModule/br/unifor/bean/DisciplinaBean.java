package br.unifor.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.dao.DisciplinaDAO;
import br.unifor.entity.Disciplina;

/**
 * Session Bean implementation class DisciplinaBean
 */
@Stateless
public class DisciplinaBean implements DisciplinaBeanRemote {

	@EJB
	private DisciplinaDAO disciplinaDAO;
	
    /**
     * Default constructor. 
     */
    public DisciplinaBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Disciplina buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "Hello World";
	}

	@Override
	public String inserir(Disciplina disciplina) {
		
		return disciplinaDAO.inserir(disciplina);
		
	}

	@Override
	public List<Disciplina> listar() {
		
		return disciplinaDAO.listar();
	}

}
