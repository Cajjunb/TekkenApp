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

/**
 *
 * @author Leandro
 */
@Named
@ViewScoped
public class PersonagensHelper implements Serializable {
    private Session session = null;
    
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
            Query q = session.createQuery("from Personagens as char  where char.nome = 'Jin'");
            chars = (ArrayList<Personagens>) q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(chars == null)
            return chars;
        else
            return (ArrayList<Personagens>)chars.clone();
    }
    
    
    
}
