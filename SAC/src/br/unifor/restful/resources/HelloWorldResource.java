package br.unifor.restful.resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.unifor.bean.DisciplinaBeanRemote;

@Stateless
@Path("/helloworld")
public class HelloWorldResource {
	
	@EJB
    private DisciplinaBeanRemote disciplinaBean;

    @GET
    @Produces("text/plain")
    public String showHelloWorld() {
        return disciplinaBean.hello();
    }
}