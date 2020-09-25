/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpersmodelos;


import java.io.Serializable;
import modelos.Personagens;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import utilidades.HibernateUtil;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    
    @Override
    public void salvarPersonagem(Personagens personagem) {
        this.em.persist(personagem);
        return ;
    }

    @Override
    public void alterarPersonagem(Personagens personagem) {
        Personagens personagemMerge = this.em.merge(personagem);
        this.em.persist(personagemMerge);
    }

    @Override
    public void deletarPersonagem(Personagens personagem){
        Personagens personagemMerge = this.em.merge(personagem);
        this.em.remove(personagemMerge);
    }

    @Override
    public List<Personagens> getListaPersonagens() {
        Query q = em.createQuery("from Personagens");
        return q.getResultList();
    }
    
   
    
}