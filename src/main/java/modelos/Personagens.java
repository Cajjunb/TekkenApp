package modelos;
// Generated 24/06/2020 16:59:01 by Hibernate Tools 4.3.1

import java.util.Set;


/**
 * Personagens generated by hbm2java
 */
public class Personagens  implements java.io.Serializable {


     private int id;
     private String  nome;
     private String fotoUrl;
     private Set<Golpes> golpes;

    public Personagens() {
    }

    public Personagens(int id, String nome, String fotoUrl) {
       this.id = id;
       this.nome = nome;
       this.fotoUrl = fotoUrl;
    }

    @Override
    public String toString() {
        return "Personagens{" + "nome=" + nome + ", fotoUrl=" + fotoUrl + '}';
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




}


