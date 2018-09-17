/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
        Scanner sc = new Scanner(System.in);
        double p;
        String pergunta = new String();

        //criaçao do cabeçario
        System.out.println("Digite o nome da disciplina: ");
        x.setNomeDisciplina(sc.nextLine());

        System.out.println("Digite o local: ");
        x.setLocal(sc.nextLine());

        System.out.println("Digite a data: ");
        x.setData(sc.nextLine());

        System.out.println("Digite o peso: ");

        //validação do valor do peso
        while (true) {
            try {
                p = sc.nextDouble();
                if (p < 1) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Informe um valor valido para o peso!");
                continue;
            }

        }
        x.setPeso(p);
        sc.nextLine();

        //criação das questões 
        String tipo;
        ArrayList<Questao> questoes = new ArrayList<Questao>();

        do {
            do {
                System.out.println("Digite 'D' para adicionar uma questão discursiva ou"
                        + "'O' para adicionar uma questão objetiva");
                tipo = sc.nextLine();

            } while (tipo.equals("D") != true && tipo.equals("d") != true
                    && tipo.equals("O") != true && tipo.equals("o") != true);

            //criação de questão DISCURSIVA
            if (tipo.equals("D") == true || tipo.equals("d") == true) {

                Discursiva nova = new Discursiva();

                System.out.println("Escreva a pergunta: ");
                pergunta = sc.nextLine();
                nova.setPergunta(pergunta);

                System.out.println("Digite o peso: ");

                //validação do valor do peso
                while (true) {
                    try {
                        p = sc.nextDouble();
                        if (p < 1) {
                            throw new Exception();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Informe um valor valido para o peso!");

                    }
                }
                nova.setPeso(p);
                sc.nextLine();

                System.out.println("Informa o criterio de avaliação: ");
                pergunta = sc.nextLine();
                nova.setCriterio(pergunta);

                questoes.add(nova);
            } else {

                //criação de questão OBJETIVA
                Objetiva nova1 = new Objetiva();

                System.out.println("Escreva a pergunta: ");
                pergunta = sc.nextLine();
                nova1.setPergunta(pergunta);

                System.out.println("Digite o peso: ");

                //validação do valor do peso
                while (true) {
                    try {
                        p = sc.nextDouble();
                        if (p < 1) {
                            throw new Exception();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Informe um valor valido para o peso!");

                    }
                }
                nova1.setPeso(p);
                sc.nextLine();

                //criação de alternativas
                String[] opcoes = new String[5];

                for (int j = 0; j < 5; j++) {
                    System.out.println("Digite a alternativa " + "[ " + (j + 1) + " ]: ");
                    opcoes[j] = sc.nextLine();
                }
                nova1.setOpcoes(opcoes);

                //informa a alternativa correta
                System.out.println("Informe a alternativa correta: ");
                //validação de resposta correta
                while (true) {
                    try {
                        p = Double.parseDouble(sc.nextLine());
                        if (p < 1 || p > 5) {
                            throw new IllegalArgumentException();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Informe um valor valido para a resposta correta!");
                    }
                }
                nova1.setRespostaCorreta((int) p - 1);
                questoes.add(nova1);
            }
            System.out.println("Gostaria de adicionar uma nova questão?\n "
                    + " (Digite 'S' se sim ou 'N' se não)");
            tipo = sc.nextLine();
        } while (tipo.equals("S") == true || tipo.equals("s") == true); // continua no laco enquanto o usuario quiser adicionar mais questoes na prova

        x.setQuestoes(questoes);

        //cria um novo arquivo .txt
        System.out.println("Insira um nome para o arquivo gerado: ");
        pergunta = sc.nextLine();

        File file = new File(pergunta + ".txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter escritos = new FileWriter(file, true);
            BufferedWriter escrita = new BufferedWriter(escritos);

            escrita.write(x.obtemProvaImpressao());
            escrita.close();
        } catch (Exception e) {
            System.out.println("ERRO");
        }

    }
}
