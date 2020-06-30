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
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    /**
     * Metodo que retorna o personagem principal
     * @return 
     */
    public ArrayList<Personagens> getPersonagemPrincipal(){
        ArrayList<Personagens> chars = null;
        try{
            session.beginTransaction();
            Query q = session.createQuery("from Personagens as char  where char.nome = 'Jin'");
            chars = (ArrayList<Personagens>) q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(chars == null)
            return chars;
        else
            return chars;
    }
    
    public ArrayList<Personagens> getListaPersonagens(){
        ArrayList<Personagens> chars = null;
        try{
            if(this.transacao == null)
                this.transacao = session.beginTransaction();
            Query q = session.createQuery("from Personagens");
            chars = (ArrayList<Personagens>) q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(chars == null)
            return chars;
        else
            return chars;
    }
    
    public boolean salvaPersonagem(Personagens registro){
        boolean resultado = false;
        try{
            if(this.transacao == null)
                this.transacao = session.beginTransaction();
            session.persist(registro);
            resultado = true;
            transacao.commit();
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
            if(this.transacao == null)
                this.transacao = session.beginTransaction();
            session.save(registro);
            resultado = true;
            transacao.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    
}
