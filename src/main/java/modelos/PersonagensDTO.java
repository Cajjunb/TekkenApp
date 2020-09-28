package modelos;
// Generated 24/06/2020 16:59:01 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * PersonagensDTO generated by hbm2java
 */
@XmlRootElement
public class PersonagensDTO  implements Serializable{

     @Id
     @GeneratedValue
     private int id;
     private String  nome;
     private String fotoUrl;
     private Set<GolpesDTO> golpes;

    public PersonagensDTO() {
    }

    
    public PersonagensDTO(Personagens personagem){
        this.id = personagem.getId();
        this.nome = personagem.getNome();
        this.fotoUrl = personagem.getFotoUrl();
//        this.golpes = new HashSet<GolpesDTO>();
//        for(Golpes golpe : personagem.getGolpes()){
//            this.golpes.add(new GolpesDTO(golpe));
//        }
    }
    
    
    @Override
    public String toString() {
        JSONObject  json = new JSONObject();
        json.put("fotoUrl", this.fotoUrl);
        json.put("nome", this.nome);
        json.put("id", this.id);
        return json.toString();
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFotoUrl() {
        return this.fotoUrl == null? "" : this.fotoUrl;
    }
    
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Set<GolpesDTO> getGolpes() {
        return golpes;
    }

    public void setGolpes(Set<GolpesDTO> golpes) {
        this.golpes = golpes;
    }




}


