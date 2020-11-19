/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelos.UsuarioDTO;
import servicos.ServicosUsuarios;

/**
 *
 * @author leandro
 */
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioFacade {
    @POST
    @Path("/signin")
    public UsuarioDTO executaPostLogin(UsuarioDTO usuariodto){
        //EXECUTA HELPER e verifica se a senha é igual
        return new ServicosUsuarios().executaPostLogin(usuariodto);
    }
    
   
    
    
}
