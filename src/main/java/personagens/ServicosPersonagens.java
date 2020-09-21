/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import helpersmodelos.PersonagensHelper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelos.Personagens;
import modelos.PersonagensDTO;
/**
 *
 * @author Leandro
 */

@Path("/personagens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Named
public class ServicosPersonagens  {
    
    @Inject
    private PersonagensHelper helpChars ;
    private Personagens charPrincipal; 
    private ArrayList<Personagens> listaChar;
    private String inputStringPersonagem, inputGolpeNovo;
    
    static ArrayList<Personagens> listaStaticChars = new ArrayList<Personagens>(); 
    
    static{
    }
    
    
    @GET
    public List<PersonagensDTO> mostra(){
        if(listaStaticChars.isEmpty())
            listaStaticChars = this.helpChars.getListaPersonagens();
//        this.listaChar = this.helpChars.getListaPersonagens();
        ArrayList<PersonagensDTO> relacao = new ArrayList<>();
        for(Personagens personagem: listaStaticChars){
            relacao.add(new PersonagensDTO(personagem));
        }
        return relacao;
    }
    
    @POST
    public boolean executaPost(PersonagensDTO personagemdto){
        boolean resultado = false;
        System.out.println("POST");
        Personagens novo = new Personagens(personagemdto);
        listaStaticChars.add(novo);
        return resultado;
    }
    
    
    @PUT
    public boolean executaPut(PersonagensDTO personagemdto){
        System.out.println("PUT");
        Personagens novo = new Personagens(personagemdto);
        listaStaticChars.remove(novo);
        listaStaticChars.add(novo);
        return false;
    }
    
    @DELETE
    public boolean executaDelete(PersonagensDTO personagemdto){
        System.out.println("DELETE");
        Personagens novo = new Personagens(personagemdto);
        listaStaticChars.remove(novo);
        return false;
    }
    

}
