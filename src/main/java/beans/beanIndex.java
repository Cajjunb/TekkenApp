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
    
    
    @PostConstruct
    public void init(){
        this.listaChar = this.helpChars.getListaPersonagens();
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
}
