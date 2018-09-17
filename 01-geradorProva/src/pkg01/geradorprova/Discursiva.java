/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author 6093914
 */
public class Discursiva extends Questao {

    private String criterio;

    public String getCriterio() {
        return criterio;
    }

    /**
     * @param criterio the criteriosCorrecao to set
     */
    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    @Override
    String retornaQuestao() {
        return "(" + this.getPeso() + ")" + this.getPergunta() + "\r";
    }

}
