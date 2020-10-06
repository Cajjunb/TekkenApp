/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
/**
 *
 * @author Leandro
 */
@Named
public class GolpesHelper implements Serializable,GolpesInterface{

    @PersistenceContext(unitName="TekkenAppPersistenceUnit")
    private EntityManager em;
    @Resource
    private UserTransaction transacao;
    
    @Override
    public boolean salvarGolpe(Golpes golpe) {
        boolean resultado = false;
        try {
            this.transacao.begin();
            this.em.persist(golpe);
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
    public boolean alterarGolpe(Golpes golpe) {
        boolean resultado = false;
        try {
            this.transacao.begin();
            Golpes golpesMerge = this.em.merge(golpe);
            this.em.persist(golpesMerge);
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
    public boolean deletarGolpe(Golpes golpe){
        boolean resultado = false;
        try {
            this.transacao.begin();
            Golpes golpesMerge = this.em.merge(golpe);
            this.em.remove(golpesMerge);
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
    
}