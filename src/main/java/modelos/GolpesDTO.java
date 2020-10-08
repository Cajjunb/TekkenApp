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
    private int blockframes;
    private int hitframes;
    private int chframes;
    private Personagens personagem;
    

    public GolpesDTO(){}
    
    public GolpesDTO(Golpes golpe){
        this.id = golpe.getId();
        this.nomeGolpe = golpe.getNomeGolpe();
        this.input = golpe.getInput();
        this.blockframes = golpe.getBlockframes();
        this.hitframes = golpe.getHitframes();
        this.chframes = golpe.getChframes();
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

    public int getBlockframes() {
        return blockframes;
    }

    public void setBlockframes(int blockframes) {
        this.blockframes = blockframes;
    }

    public int getHitframes() {
        return hitframes;
    }

    public void setHitframes(int hitframes) {
        this.hitframes = hitframes;
    }

    public int getChframes() {
        return chframes;
    }

    public void setChframes(int chframes) {
        this.chframes = chframes;
    }

    public Personagens getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagens personagem) {
        this.personagem = personagem;
    }
    
    
}
