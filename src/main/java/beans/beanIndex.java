package beans;

import helpersmodelos.PersonagensHelper;
import modelos.Personagens;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelos.Golpes;
/**
 *
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the temTplate in the editor.
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
    private Personagens charSelecionado;
    private ArrayList<Personagens> listaChar;
    private String inputStringPersonagem, inputGolpeNovo;
    
    @PostConstruct
    public void init(){
        try{
            InitialContext initialContext = new InitialContext();
            Context env = (Context) initialContext.lookup("java:/comp/env");
            System.out.println(env.lookup("myConnectionURL"));
        }catch(NamingException e){
        
        }
        this.listaChar = this.helpChars.getListaPersonagens();
        this.charPrincipal = new Personagens() ;
        this.inputGolpeNovo = new String();
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
    
    /**
     * Metodo que faz o carregamento lazy dos golpes de um determinado personagem
     * @param personagem 
     */
    public void pegaListaGolpes(Personagens personagem){
        personagem = this.helpChars.getPersonagensGolpes(personagem);
        this.listaChar.set(this.listaChar.indexOf(personagem),personagem);
    }
    
    
    public void debug(){
        Personagens aux = null;
        for(Personagens p : this.listaChar){
            if(p.getNome().equals("Kazuya"))
                aux = p;
        }
        aux = this.helpChars.getPersonagensGolpes(aux);
        this.setCharPrincipal(aux);
//        for(Golpes golpe : golpes){
//            System.out.println(golpe.getInput());
//        }
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"DEBUG", 
                        ((Golpes)aux.getGolpes().toArray()[1]).getNomeGolpe() ) );
    }
    
    /**
     * Insere um golpe novo para o determinado personagem. O personagem dono do golpe eh em argumento
     * @param personagem
     * @return 
     */
    public boolean criaGolpe(Personagens personagem){
        boolean retorno = false;
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"TENTANDO SALVAR GOLPE", 
                        "DEBUG")) ;
        if(this.inputGolpeNovo.equals("") == false){
            this.helpChars.salvaGolpeNovo("",this.inputGolpeNovo,personagem);
            // SALVA
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo novo Golpe", 
                            "DEBUG")) ;
        }
        return retorno;
    }
    
    /**
     * Metodo de deletar personagem. Usado na datatable.
     * @param personagem
     * @return 
     */
    public boolean deletaPersonagem(Personagens personagem){
        boolean resultado = false;
        if(personagem != null){
            resultado = this.helpChars.deletaPersonagem(personagem);
            // SALVA
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Personagem Deletado!", 
                            "")) ;
        }
        return resultado;
    }
    
    /**
     * Funcao que Cria uma nova instancia de Char e salva no banco
     * @return boolean o resultado da operacao
     */
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

    public String getInputGolpeNovo() {
        return inputGolpeNovo;
    }

    public void setInputGolpeNovo(String inputGolpeNovo) {
        this.inputGolpeNovo = inputGolpeNovo;
    }

    public Personagens getCharSelecionado() {
        return charSelecionado;
    }

    public void setCharSelecionado(Personagens charSelecionado) {
        this.charSelecionado = charSelecionado;
    }

    
}
