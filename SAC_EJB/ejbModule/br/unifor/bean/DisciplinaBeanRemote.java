package br.unifor.bean;

import java.util.List;

import javax.ejb.Remote;

import br.unifor.entity.Disciplina;


@Remote
public interface DisciplinaBeanRemote {

	Disciplina buscar(Long id);
	
	String inserir(Disciplina disciplina);
	
	String hello();

	List<Disciplina> listar();

}
