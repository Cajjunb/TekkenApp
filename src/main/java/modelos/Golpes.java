/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;

/**
 *
 * @author Leandro
 */
public class Golpes implements Serializable{
    
    private int id;
    private String nomeGolpe;
    private String input;
    private Personagens personagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeGolpe() {
        return nomeGolpe;
    }

    public void setNomeGolpe(String nomeGolpe) {
        this.nomeGolpe = nomeGolpe;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Personagens getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagens personagem) {
        this.personagem = personagem;
    }
    
    
    
    
}