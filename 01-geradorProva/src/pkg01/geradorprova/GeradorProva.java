/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 6093914
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Prova x = new Prova();

        //criaçao do cabeçario
        System.out.println("Digite o nome da disciplina: ");
        Scanner sc = new Scanner(System.in);
        x.setNomeDisciplina(sc.nextLine());
        System.out.println("Digite o local: ");
        x.setLocal(sc.nextLine());
        System.out.println("Digite a data: ");
        x.setData(sc.nextLine());
        System.out.println("Digite o peso: ");
        x.setPeso(sc.nextInt());
        sc.nextLine();

        //criação das questões discursivas
        System.out.println("Digite a quantidade de questões discursivas: ");
        int qtd = sc.nextInt();
        sc.nextLine();
        Discursiva d[] = new Discursiva[qtd];
        for (int i = 0; i < qtd; i++) {
            d[i] = new Discursiva();
            System.out.println("Digite a " + (i + 1) + "ª pergunta: ");
            d[i].setPergunta(sc.nextLine());
            System.out.println("Critério de avaliação: ");
            d[i].setCriteriosCorrecao(sc.nextLine());
            System.out.println("Peso: ");
            d[i].setPeso(sc.nextInt());
            sc.nextLine();
            System.out.println("\n");
        }
        x.setDiscursiva(d);

        //criaçao das questoes objetivas
        System.out.println("Digite a quantidade de questões objetivas: ");
        qtd = sc.nextInt();
        sc.nextLine();
        Objetiva o[] = new Objetiva[qtd];
        String opcoes[] = new String[5];
        for (int i = 0; i < qtd; i++) {
            o[i] = new Objetiva();
            System.out.println("Digite a " + (i + 1) + "ª pergunta: ");
            o[i].setPergunta(sc.nextLine());
            System.out.println("Peso: ");
            o[i].setPeso(sc.nextInt());
            sc.nextLine();
            System.out.println("Digite as alternativas: ");
            for (int j = 0; j < 5; j++) {
                System.out.println((j + 1) + "ª alternativa: ");
                opcoes[j] = sc.nextLine();
            }
            o[i].setOpcoes(opcoes);
            int alternativa;
            do {
                System.out.print("Qual é a alternativa correta? ");
                alternativa = sc.nextInt();
                sc.nextLine();
            } while (alternativa < 0 || alternativa > 6);
            o[i].setRespostaCorreta(alternativa - 1);
        }
        x.setObjetiva(o);

        System.out.println(x.obtemDetalhes());
        System.out.println(x.obtemProvaImpressao());
        //JOptionPane.showMessageDialog(null, x .obtemProvaImpressao());
    }

}
