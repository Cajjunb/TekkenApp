/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import javax.inject.Named;
import modelos.Usuario;
import modelos.UsuarioDTO;

/**
 *
 * @author leandro
 */
@Named
public class ServicosUsuarios {
    
    public UsuarioDTO executaPostLogin(UsuarioDTO usuarriodto){
        return new UsuarioDTO(new Usuario(1,"Leandro","123456"));
    }
    
    public UsuarioDTO executaPostCadastro(UsuarioDTO usuarriodto){
        return null;
    }
    
}
