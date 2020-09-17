/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro
 */
@XmlRootElement
public class GolpesDTO implements Serializable{
    
    private int id;
    private String nomeGolpe;
    private String input;

    public GolpesDTO(){}
    
    public GolpesDTO(Golpes golpe){
        this.id = golpe.getId();
        this.nomeGolpe = golpe.getNomeGolpe();
        this.input = golpe.getInput();
    }
    
    public GolpesDTO(String nomeGolpe, String input, Personagens personagem) {
        this.nomeGolpe = nomeGolpe;
        this.input = input;
    }

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
    
}
