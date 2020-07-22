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
    private PersonagensHelper helpChars;
    private Personagens charPrincipal;
    private ArrayList<Personagens> listaChar;
    private String inputStringPersonagem;
    
    @PostConstruct
    public void init(){
        this.listaChar = this.helpChars.getListaPersonagens();
        this.charPrincipal = new Personagens() ;
    }

    /**
     * Ouvidor do Evento Cell EDIT
     * @param registro 
     */
    public void salvaPersonagem(Personagens registro){
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"TENTANDO !" + registro.toString(),"" )) ;
        if (this.helpChars.salvaPersonagem(registro))
            FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Personagem Salvo!", "")) ;
        else
            FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Erro!", "Personagem não foi alterado!")) ;
    }
    
    public void debug(){
        System.out.println(this.charPrincipal.getNome());
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"DEBUG", 
                        "DEBUG")) ;
    }
    
    
    
    
    public boolean criaChar(){
        System.out.println(this.charPrincipal.getNome());
        System.out.println(this.charPrincipal.getFotoUrl());
        if(this.charPrincipal.getNome().equals("") == false){
            Personagens registroNovo = new Personagens();
            registroNovo.setNome(this.charPrincipal.getNome());
            registroNovo.setFotoUrl("Nulo");
            FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"TENTANDO!", 
                        this.inputStringPersonagem +" começando a ser inserido!")) ;
            //USA HELPER PARA CRIAR UM NOVO
            if(this.helpChars.salvaPersonagemNovo(registroNovo)  ==true ){
                FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Concluido", 
                            this.inputStringPersonagem +" foi inserido!")) ;
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
    
    public String getInputStringPersonagem() {
        return inputStringPersonagem;
    }

    public void setInputStringPersonagem(String inputStringPersonagem) {
        this.inputStringPersonagem = inputStringPersonagem;
    }

    
}
