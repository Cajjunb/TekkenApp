/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelos.Personagens;
import modelos.PersonagensDTO;

/**
 *
 * @author leandro
 */
@Path("/golpes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GolpesFacades {
            
    @GET
    public List<Personagens> executaGet(PersonagensDTO pdto){
        return null;
    }
    
}
