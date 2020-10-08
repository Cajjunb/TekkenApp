/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro
 */
@Entity(name="Golpes")
@Table(name="golpes")
@XmlRootElement
public class Golpes implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="nome",length=100, nullable=false)
    private String nomeGolpe;
    @Column(name="input",length=100, nullable=false)
    private String input;
    @Column(name="blockframe", nullable=true)
    private int blockframes;
    @Column(name="hitframe", nullable=true)
    private int hitframes;
    @Column(name="chframe", nullable=true)
    private int chframes;
    
    @ManyToOne
    private Personagens personagem;

    public Golpes(){}
    
    public Golpes(String nomeGolpe, String input, Personagens personagem) {
        this.nomeGolpe = nomeGolpe;
        this.input = input;
        this.personagem = personagem;
    }
    
    //Construtor a partir de um golpe orfao (sem referencia para o personagem pai)
    public Golpes(GolpesOrfaoDTO golpedto, Personagens personagem){
        this.id = golpedto.getId();
        this.nomeGolpe = golpedto.getNomeGolpe();
        this.input = golpedto.getInput();
        this.personagem = personagem;
        this.blockframes = golpedto.getBlockframes();
        this.hitframes = golpedto.getHitframes();
        this.chframes = golpedto.getChframes();
    }
    
    
    //Construtor a partir de um golpe com referencia para o personagem pai
    public Golpes(GolpesDTO golpedto){
        this.id = golpedto.getId();
        this.nomeGolpe = golpedto.getNomeGolpe();
        this.input = golpedto.getInput();
        this.personagem = golpedto.getPersonagem();
        this.blockframes = golpedto.getBlockframes();
        this.hitframes = golpedto.getHitframes();
        this.chframes = golpedto.getChframes();
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

    public Personagens getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagens personagem) {
        this.personagem = personagem;
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
    
}