/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelos.Personagens;
import modelos.PersonagensDTO;
import servicos.ServicosPersonagens;

/**
 *
 * @author leandro
 */

@Path("/personagens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonagensFacade {
    @Inject
    private ServicosPersonagens servPersonagens;
    
    @GET
    public List<PersonagensDTO> mostra(){
        return this.servPersonagens.mostra();
    }
    
    @POST
    public boolean executaPost(PersonagensDTO personagemdto){
        return this.servPersonagens.executaPost(personagemdto);
    }
    
    @PUT
    public boolean executaPut(PersonagensDTO personagemdto){
        return this.servPersonagens.executaPut(personagemdto);
    }
    
    @DELETE
    public boolean executaDelete(PersonagensDTO personagemdto){
        return this.servPersonagens.executaDelete(personagemdto);
    }
}
