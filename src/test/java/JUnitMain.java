/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leandro
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JUnitMain extends JUnitCore {
    public static void main(String args[]){
        Result resultado = JUnitCore.runClasses(CharsTest.class);
        for(Failure falha: resultado.getFailures()){
            System.out.println(falha.toString());
        }
        System.out.println(resultado.wasSuccessful());
    }
    
}
