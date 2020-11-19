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
public class UsuarioDTO {
    private int id;
    private String nome;
    private String passwordenc;

    public UsuarioDTO(Usuario usuario){
        this.setId(usuario.getId()); 
        this.setNome(usuario.getNome());
        this.setPasswordenc(usuario.getPasswordenc());
    }

    public UsuarioDTO(String nome, String passwordenc) {
        this.nome = nome;
        this.passwordenc = passwordenc;
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

    public String getPasswordenc() {
        return passwordenc;
    }

    public void setPasswordenc(String passwordenc) {
        this.passwordenc = passwordenc;
    }
    
}
