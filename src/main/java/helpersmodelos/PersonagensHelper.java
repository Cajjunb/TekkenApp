/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpersmodelos;


import java.io.Serializable;
import modelos.Personagens;
import java.util.ArrayList;
import javax.inject.Named;
import org.hibernate.Query;
import utilidades.HibernateUtil;
import org.hibernate.Session;
import javax.faces.bean.ViewScoped;
import modelos.Golpes;
import org.hibernate.Transaction;

/**
 *
 * @author Leandro
 */
@Named
@ViewScoped
public class PersonagensHelper implements Serializable {
    
    private Session session = null;
    private  Transaction transacao = null;
    
    public PersonagensHelper(){
    }
    
    public ArrayList<Personagens> getListaPersonagens(){
        ArrayList<Personagens> chars = null;
        try{
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            this.transacao = session.beginTransaction();
            Query q = session.createQuery("from Personagens");
            chars = (ArrayList<Personagens>) q.list();
            this.session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(chars == null)
            return chars;
        else
            return chars;
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
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            this.transacao = session.beginTransaction();
            session.saveOrUpdate(golpeNovo);
            resultado = true;
            transacao.commit();
            this.session.close();
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
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            this.transacao = session.beginTransaction();
            session.saveOrUpdate(registro);
            resultado = true;
            transacao.commit();
            this.session.close();
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
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            this.transacao = session.beginTransaction();
            session.saveOrUpdate(registro);
            resultado = true;
            transacao.commit();
            this.session.close();
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
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            this.transacao = session.beginTransaction();
            session.save(registro);
            resultado = true;
            transacao.commit();
            this.session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    
}
