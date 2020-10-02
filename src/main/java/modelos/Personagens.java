package modelos;
// Generated 24/06/2020 16:59:01 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONException;
import org.json.JSONObject;
import sun.jvm.hotspot.gc.shared.Generation;

/**
 * Personagens generated by hbm2java
 */
@Entity(name="Personagens")
@Table(name="personagens")
@XmlRootElement
public class Personagens  implements Serializable{

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
     @Column(name="nome")
     private String  nome;
     @Column(name="foto_url",nullable=true)
     private String fotoUrl;
     @OneToMany(mappedBy="personagem", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
     private Set<Golpes> golpes;

    public Personagens() {
    }

    public Personagens(int id, String nome, String fotoUrl) {
       this.id = id;
       this.nome = nome;
       this.fotoUrl = fotoUrl== null? "null":fotoUrl;
    }
    
    public Personagens(String nome){
        this.nome = nome;
        this.fotoUrl = "NULO";
    }
    
    /**
     * Construtor a partir de um objeto DTO. Faz toda a cadeia de Conversao DTO.
     * @param personagem 
     */
    public Personagens(PersonagensDTO personagem){
        this.id = personagem.getId();
        this.nome = personagem.getNome();
        this.fotoUrl = personagem.getFotoUrl();
        if(personagem.getGolpes() != null){
            HashSet<Golpes> golpesConvertidos = new HashSet<>();
            for(GolpesDTO golpedto : personagem.getGolpes()){
                golpesConvertidos.add(new Golpes(golpedto, this));
            }
            this.golpes = golpesConvertidos;
        }
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
        return this.fotoUrl;
    }
    
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Set<Golpes> getGolpes() {
        return golpes;
    }

    public void setGolpes(Set<Golpes> golpes) {
        this.golpes = golpes;
    }

    @Override
    public boolean equals(Object obj){
        boolean resultado = false;
        if(     obj != null && 
                obj instanceof Personagens && 
                ((Personagens)obj).getId() == this.id ){
            resultado = true;
        }
        return resultado;
    }
}


