/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


import java.io.Serializable;
import modelos.Personagens;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Named;
import utilidades.HibernateUtil;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import modelos.Golpes;
import modelos.PersonagensInterface;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Leandro
 */
@Named
public class PersonagensHelper implements Serializable,PersonagensInterface{

    @PersistenceContext(unitName="TekkenAppPersistenceUnit")
    private EntityManager em;
    @Resource
    private UserTransaction transacao;
    
    @Override
    public boolean salvarPersonagem(Personagens personagem) {
        boolean resultado = false;
        try {
            this.transacao.begin();
            this.em.persist(personagem);
            this.transacao.commit();
            resultado = true;
        } catch (RollbackException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean alterarPersonagem(Personagens personagem) {
        boolean resultado = false;
        try {
            this.transacao.begin();
            Personagens personagemMerge = this.em.merge(personagem);
            this.em.persist(personagemMerge);
            this.transacao.commit();
            resultado = true;
        } catch (SecurityException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deletarPersonagem(Personagens personagem){
        boolean resultado = false;
        try {
            this.transacao.begin();
            Personagens personagemMerge = this.em.merge(personagem);
            this.em.remove(personagemMerge);
            this.transacao.commit();
            resultado = true;
        } catch (SecurityException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(PersonagensHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public List<Personagens> getListaPersonagens() {
            Query q = em.createQuery("from Personagens");
            return q.getResultList();
    }
    
}