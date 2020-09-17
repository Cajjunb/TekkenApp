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
import javax.ws.rs.POST;
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
public class ServicosPersonagens  {
    
    @Inject
    private PersonagensHelper helpChars ;
    private Personagens charPrincipal; 
    private ArrayList<Personagens> listaChar;
    private String inputStringPersonagem, inputGolpeNovo;
    
    
    
    @GET
    public List<PersonagensDTO> mostra(){
        this.listaChar = this.helpChars.getListaPersonagens();
        ArrayList<PersonagensDTO> relacao = new ArrayList<>();
        for(Personagens personagem: this.listaChar){
            relacao.add(new PersonagensDTO(personagem));
        }
        return relacao;
    }
    
    @POST
    public String executaPost(){
        return "POST";
    }
    

}
