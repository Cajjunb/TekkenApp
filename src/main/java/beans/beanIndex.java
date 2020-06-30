package beans;

import helpersmodelos.PersonagensHelper;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelos.Personagens;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leandro
 */
@Named
@ViewScoped
public class beanIndex implements Serializable {
    @Inject
    private PersonagensHelper helpChars ;
    private Personagens charPrincipal;
    private ArrayList<Personagens> listaChar;
    private Personagens personagemNovo;
    
    @PostConstruct
    public void init(){
        this.listaChar = this.helpChars.getListaPersonagens();
        this.personagemNovo = new Personagens() ;
    }

    /**
     * Ouvidor do Evento Cell EDIT
     * @param registro 
     */
    public void salvaPersonagem(Personagens registro){
        if (this.helpChars.salvaPersonagem(registro))
            FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Personagem Salvo!", "")) ;
        else
            FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Erro!", "Personagem não foi alterado!")) ;
    }
    
    
    public boolean criaChar(){
        if(this.personagemNovo.getNome() != null){
            FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"TENTANDO!", 
                        this.personagemNovo.getNome() +" começando a ser inserido!")) ;
            //USA HELPER PARA CRIAR UM NOVO
            if(this.helpChars.salvaPersonagemNovo(this.personagemNovo)  ==true ){
                FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Concluido", 
                            this.personagemNovo.getNome() +" foi inserido!")) ;
                this.personagemNovo = new Personagens();
            }
        }else{
            System.out.println("ENTREI ELSE");
            FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO!", 
                        "Não foi possivel inserir !")) ;
        }
        return true;
    }
    
    //GETTERS E SETTERS
    public PersonagensHelper getHelpChars() {
        return helpChars;
    }

    public void setHelpChars(PersonagensHelper helpChars) {
        this.helpChars = helpChars;
    }

    public Personagens getCharPrincipal() {
        return charPrincipal;
    }

    public void setCharPrincipal(Personagens charPrincipal) {
        this.charPrincipal = charPrincipal;
    }
    
    public ArrayList<Personagens> getListaChar() {
        return listaChar;
    }

    public void setListaChar(ArrayList<Personagens> listaChar) {
        this.listaChar = listaChar;
    }

    public Personagens getPersonagemNovo() {
        return personagemNovo;
    }

    public void setPersonagemNovo(Personagens personagemNovo) {
        this.personagemNovo = personagemNovo;
    }
    
}
