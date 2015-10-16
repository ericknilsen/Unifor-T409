package br.unifor.restful.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.bean.DisciplinaBeanRemote;
import br.unifor.entity.Disciplina;
import br.unifor.restful.vo.DisciplinaVO;

@Stateless
@Path("/disciplina")
public class DisciplinaResource {

	@EJB
	private DisciplinaBeanRemote disciplinaBean;

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String inserir(DisciplinaVO disciplinaVO) {

		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(disciplinaVO.getCodigo());
		disciplina.setNome(disciplinaVO.getNome());

		return disciplinaBean.inserir(disciplina);
	}

	@GET
	@Produces("application/json")
	public List<DisciplinaVO> listar() {
		
		List<Disciplina> listaDisciplinas = disciplinaBean.listar();			
		
		List<DisciplinaVO> listaDisciplinasVO = new ArrayList<DisciplinaVO>();
				
		for (Disciplina disciplina : listaDisciplinas) {
			DisciplinaVO disciplinaVO = new DisciplinaVO();			
			
			disciplinaVO.setId(disciplina.getId());
			disciplinaVO.setCodigo(disciplina.getCodigo());
			disciplinaVO.setNome(disciplina.getNome());
			
			listaDisciplinasVO.add(disciplinaVO);
			
		}
				
		return listaDisciplinasVO;
		

	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public DisciplinaVO buscar(@PathParam("id") Long id) {

		Disciplina disciplina = disciplinaBean.buscar(id);

		DisciplinaVO disciplinaVO = new DisciplinaVO();
		disciplinaVO.setId(disciplina.getId());
		disciplinaVO.setCodigo(disciplina.getCodigo());
		disciplinaVO.setNome(disciplina.getNome());

		return disciplinaVO;
	}
}