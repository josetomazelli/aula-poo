/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author 6093914
 */
public class Prova {

    private String nomeDisciplina;
    private double peso;
    private String local;
    private String data;
    private ArrayList<Questao> questoes;

    public Prova() {
    }

    public Prova(String n, int p, String local, String data) {
        this.nomeDisciplina = n;
        this.peso = p;
        this.local = local;
        this.data = data;
    }

    public String obtemDetalhes() {
        return "Nome da disciplina: " + this.getNomeDisciplina() + "\r\n" + "Peso: " + this.getPeso() + "\r\n" + "Local: " + this.getLocal() + "\r\n" + "data: " + this.getData();
    }

    public String obtemProvaImpressao() {
        String retorno = obtemDetalhes() + "\r\n============================\r\n";
        String questao = "";
        int j = 1;

        for (int i = 0; i < this.questoes.size(); i++) {
            questao += j;
            questao += this.questoes.get(i).retornaQuestao();
            j++;
        }
        retorno += questao;
        return retorno;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    /**
     * @param nomeDisciplina the nomeDisciplina to set
     */
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @param questoes the questoes to set
     */
    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }

}
