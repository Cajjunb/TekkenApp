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
public interface GolpesInterface {
    boolean salvarGolpe(Golpes golpe);
    boolean alterarGolpe(Golpes personagem);
    boolean deletarGolpe(Golpes personagem);
}
