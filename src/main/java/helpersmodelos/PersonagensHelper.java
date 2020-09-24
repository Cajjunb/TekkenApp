/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpersmodelos;


import java.io.Serializable;
import modelos.Personagens;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.hibernate.Query;
import utilidades.HibernateUtil;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import modelos.Golpes;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Leandro
 */
@Named
public class PersonagensHelper implements Serializable {
    
    private Session session = null;
    private SessionFactory fabricaSessao;
    private  Transaction transacao = null;
    
    
    @PostConstruct
    public void init(){
        this.fabricaSessao = HibernateUtil.getSessionFactory();
    }
    
    
    
    
    public ArrayList<Personagens> getListaPersonagens(){
        ArrayList<Personagens> chars = null;
        try{
            if(this.session == null  )
                this.session = this.fabricaSessao.getCurrentSession();
            if(this.transacao == null  || this.transacao.isActive() == false)
                this.transacao = session.beginTransaction();
            Query q = session.createQuery("from Personagens");
            chars = (ArrayList<Personagens>) q.list();
            this.transacao.commit();
            //this.session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(chars == null)
            return chars;
        else
            return chars;
    }
    
    /**
     * Metodo de deletar Personagens, recebe um ponteiro para um objeto Personagem
     * e o deleta. Retorna True se operação foi bem sucedida, caso contrario false
     * @param personagem
     * @return 
     */
    public boolean deletaPersonagem(Personagens personagem){
        boolean resultado = false;
        if(personagem != null){
           try{
                if(this.session == null || this.session.isOpen() == false )
                    this.session = this.fabricaSessao.getCurrentSession();
                if(this.transacao == null  || this.transacao.isActive() == false)
                    this.transacao = session.beginTransaction();
                Query q = this.session.createQuery("delete from Personagens where id ="+personagem.getId());
                q.executeUpdate();
                resultado = true;
                this.transacao.commit();
           }catch(Exception e){
                e.printStackTrace();
           }
        }
        return resultado;
    }
    
    /**
     * Salva golpe que sera criado com alguns parametros
     * @param registro
     * @return 
     */
    public boolean salvaGolpeNovo(String nomeGolpe,String input, Personagens personagem){
        boolean resultado = false;
        Golpes golpeNovo = new Golpes(nomeGolpe,input,personagem);
        try{
            
            if(this.session.isOpen() == false)
                this.session = this.fabricaSessao.getCurrentSession();
            if(this.transacao == null  || this.transacao.isActive() == false)
                    this.transacao = session.beginTransaction();
            session.saveOrUpdate(golpeNovo);
            resultado = true;
            transacao.commit();
            //this.session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    
    /**
     * Update golpe passado
     * @param registro
     * @return 
     */
    public boolean salvaGolpe(Golpes registro){
        boolean resultado = false;
        try{
            
            if(this.session.isOpen() == false)
                this.session = this.fabricaSessao.getCurrentSession();
            if(this.transacao == null  || this.transacao.isActive() == false)
                this.transacao = session.beginTransaction();
            session.saveOrUpdate(registro);
            resultado = true;
            transacao.commit();
            //this.session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    
    
    
    /**
     * Salvar Personagem Edicao
     * @param registro
     * @return 
     */
    public boolean salvaPersonagem(Personagens registro){
        boolean resultado = false;
        try{
            if(this.session == null || this.session.isOpen() == false)
                this.session = this.fabricaSessao.getCurrentSession();
            if(this.transacao == null  || this.transacao.isActive() == false)
                this.transacao = session.beginTransaction();
            session.saveOrUpdate(registro);
            resultado = true;
            //transacao.commit();
            //this.session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    /**
     * Helper que usa o hibernate para salvar um registro 
     * @param registro
     * @return 
     */
    public boolean salvaPersonagemNovo(Personagens registro){
        boolean resultado = false;
        try{
            if(this.session.isOpen() == false)
                this.session = this.fabricaSessao.getCurrentSession();
            this.transacao = session.beginTransaction();
            session.save(registro);
            resultado = true;
            //transacao.commit();
            //this.session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    
    /**
     * Metodo que inicializa o carregamento lazy dos golpes do personagem
     * @param personagem
     * @return 
     */
    public Personagens getPersonagensGolpes(Personagens personagem){
        try{
            
            if(this.session.isOpen() == false)
                this.session = this.fabricaSessao.getCurrentSession();
            if(this.transacao != null  && this.transacao.isActive() == false)
                this.transacao = session.beginTransaction();
            Hibernate.initialize(personagem.getGolpes());
            //this.session.close();
        }catch( Exception e){
            e.printStackTrace();
        }
        return personagem;
    }
    
}