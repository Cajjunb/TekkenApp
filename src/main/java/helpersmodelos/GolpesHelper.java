/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpersmodelos;

import java.io.Serializable;
import javax.inject.Named;
import modelos.Golpes;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Leandro
 */
@Named
public class GolpesHelper implements Serializable{
    
    private Session session = null;
    private  Transaction transacao = null;
    
    
    /**
     * Funcao de completar o golpe com a informacao do char através do golpe
     * @param golpe
     * @return 
     */
    public Golpes getGolpeComChar(Golpes golpe){
    
        //SER FEITO
        return golpe;
    }
    
    
}
