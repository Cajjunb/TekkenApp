/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import modelos.PersonagensHelper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelos.Personagens;
import modelos.PersonagensDTO;


//@Path("/personagens")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@Named
public class ServicosPersonagens  {
    
    @Inject
    private PersonagensHelper helpChars ;
    private Personagens charPrincipal; 
    private ArrayList<Personagens> listaChar;
    
    static List<Personagens> listaStaticChars = new ArrayList<Personagens>(); 
    
    public List<PersonagensDTO> mostra(){
        if(listaStaticChars.isEmpty())
            listaStaticChars = this.helpChars.getListaPersonagens();
        ArrayList<PersonagensDTO> relacao = new ArrayList<>();
        for(Personagens personagem: listaStaticChars){
            relacao.add(new PersonagensDTO(personagem));
        }
        return relacao;
    }
    
    public boolean executaPost(PersonagensDTO personagemdto){
        boolean resultado = false;
        System.out.println(personagemdto);
        Personagens novo = new Personagens(personagemdto);
        resultado = this.helpChars.salvarPersonagem(novo);
        listaStaticChars.add(novo);
        return resultado;
    }
    
    public boolean executaPut(PersonagensDTO personagemdto){
        boolean resultado = false;
        Personagens novo = new Personagens(personagemdto);
        listaStaticChars.remove(novo);
        listaStaticChars.add(novo);
        resultado = this.helpChars.alterarPersonagem(novo);
        return resultado;
    }
    
    public boolean executaDelete(PersonagensDTO personagemdto){
        boolean resultado = false;
        Personagens registro = new Personagens(personagemdto);
        listaStaticChars.remove(registro);
        resultado = this.helpChars.deletarPersonagem(registro);
        return resultado;
        
    }
    
    public PersonagensDTO executaGetLazy(PersonagensDTO personagemdto){
        Personagens registro = new Personagens(personagemdto);
        PersonagensDTO pDTO = new PersonagensDTO(this.helpChars.getPersonagemComGolpes(registro), true);
        return pDTO;
    }
    
}