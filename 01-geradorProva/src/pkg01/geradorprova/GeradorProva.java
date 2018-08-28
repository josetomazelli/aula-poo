/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author josegabrieltomazellisilva
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prova x = new Prova("POO");
        x.setLocal("Lab 3 - Bloco B6");
        x.setdata("2018-08-28");
        System.out.println(x.obtemDetalhes());
        
        Discursiva d = new Discursiva();
        d.setPergunta("Qual seu nome?");
        d.setPeso(0);
        d.setCriteriosCorrecao("Saber o proprio nome");
        
        Objetiva o = new Objetiva();
        
    }

}
