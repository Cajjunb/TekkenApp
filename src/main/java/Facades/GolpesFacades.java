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
import modelos.GolpesDTO;
import modelos.Personagens;
import modelos.PersonagensDTO;
import servicos.ServicosGolpes;

/**
 *
 * @author leandro
 */
@Path("/golpes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GolpesFacades {
    
    @Inject
    ServicosGolpes servico;

    @POST
    public boolean executaPost(GolpesDTO golpedto, PersonagensDTO personagemdto){
        return this.servico.executaPost(golpedto, personagemdto);
    }
    
    @PUT
    public boolean executaPut(GolpesDTO golpedto, PersonagensDTO personagemdto){
        return this.servico.executaPut(golpedto, personagemdto);
    }
    
    @DELETE
    public boolean executaDelete(GolpesDTO golpedto, PersonagensDTO personagemdto){
        return this.servico.executaDelete(golpedto, personagemdto);
    }
    
}
