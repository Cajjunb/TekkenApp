/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;

/**
 *
 * @author leandro
 */
public interface PersonagensInterface {
    boolean salvarPersonagem(Personagens personagem);
    boolean alterarPersonagem(Personagens personagem);
    boolean deletarPersonagem(Personagens personagem);
    List<Personagens> getListaPersonagens();
}
