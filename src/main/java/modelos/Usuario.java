/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leandro
 */
@Entity(name="Usuario")
@Table(name="usuarios")
@XmlRootElement
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nome",length=100, nullable=false)
    private String nome;
    
    @Column(name="password",length=300, nullable=false)
    private String password;

    public Usuario(){};
    
    public Usuario(UsuarioDTO usuariodto){
        this.setId(usuariodto.getId()); 
        this.setNome(usuariodto.getNome());
        this.setPassword(usuariodto.getPassword());
    }

    public Usuario(int id, String nome, String passwordenc) {
        this.id = id;
        this.nome = nome;
        this.password = passwordenc;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordenc) {
        this.password = passwordenc;
    }
    
}
