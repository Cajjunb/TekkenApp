/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import javax.inject.Inject;
import javax.inject.Named;
import modelos.Golpes;
import modelos.GolpesDTO;
import modelos.GolpesHelper;
import modelos.Personagens;
import modelos.PersonagensDTO;

/**
 * Classe de servico para alterar Objetos do tipo Golpe
 * Nao foi implementada a listagem pois a listagem eh responsabilidade da classe
 * Personagens
 * @author leandro
 */

@Named
public class ServicosGolpes {
    
    @Inject
    GolpesHelper helper;
    
    public boolean executaPost(GolpesDTO golpedto, PersonagensDTO personagemdto){
        boolean resultado = false;
        Personagens personagem = new Personagens(personagemdto);
        Golpes golpe = new Golpes(golpedto,personagem);
        try{
            this.helper.salvarGolpe(golpe);
            resultado = true;
        }catch(Exception e){
            
        }
        return resultado;
    }
    
    
    public boolean executaPut(GolpesDTO golpedto, PersonagensDTO personagemdto){
        boolean resultado = false;
        Personagens personagem = new Personagens(personagemdto);
        Golpes golpe = new Golpes(golpedto,personagem);
        try{
            this.helper.alterarGolpe(golpe);
            resultado = true;
        }catch(Exception e){
            
        }
        return resultado;
    }
    
    
    public boolean executaDelete(GolpesDTO golpedto, PersonagensDTO personagemdto){
        boolean resultado = false;
        Personagens personagem = new Personagens(personagemdto);
        Golpes golpe = new Golpes(golpedto,personagem);
        try{
            this.helper.deletarGolpe(golpe);
            resultado = true;
        }catch(Exception e){
            
        }
        return resultado;
    }
    
}
