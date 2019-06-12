/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;


public class Grafos {

   
    LinkedList<Integer> Arestas [];
    int n;
    int qtd_Arestas = 0;
    
    public interface Pilha<T> {
    public T top() throws NoSuchElementException;
    public T pop() throws NoSuchElementException;
    public void push(T element);
    public boolean isEmpty();
}
    public class PilhaArrayList<T> implements Pilha<T> {
    private final List<T> elementos;

    public PilhaArrayList() {
        this.elementos = new ArrayList<>();
    }

    @Override
    public T top() throws NoSuchElementException {
         if (isEmpty()) throw new NoSuchElementException();
         return elementos.get(elementos.size() - 1);
    }

    @Override
    public T pop() throws NoSuchElementException {
         if (isEmpty()) throw new NoSuchElementException();
         return elementos.remove(elementos.size() - 1);
    }

    @Override
    public void push(T element) {
        elementos.add(element);
    }

    @Override
    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
    
    public Grafos(int n){
        this.n = n;
        Arestas = new LinkedList[n];
        for (int i=0; i<n; ++i)
            Arestas[i] = new LinkedList();
    }
    public void Adiciona_aresta(int origem, int destino){
        Arestas[origem].add(destino);
        qtd_Arestas++;
    }
    public int DFS(int S, boolean visited[], int contador){
        visited[S] = true;
        ListIterator<Integer> v = Arestas[S].listIterator();
        while(v.hasNext()) {
            n = v.next();
            System.out.println(S + ">>" + n);
            if(!visited[n]){
                contador = DFS(n,visited,contador+1);
            }
        }
        return contador+1;

    }
    
    public void DFS_ini(int S){
        boolean Visitados[] = new boolean [n];
        int contador = 0;
        int b = DFS(S,Visitados,contador);
        System.out.println("____________________________________________________");
    }
    
    public void pilhaDFS(int s) {
        boolean[] visitados = new boolean[n];
        visitados[s] = true;
        Pilha<Integer> pilha = new PilhaArrayList<>();
        pilha.push(s);
        while (!pilha.isEmpty()) {
            int topo = pilha.pop();
            for (int linha : Arestas[s]) {
                if (visitados[linha]) continue;
                System.out.println(s + ">>" + linha);
                visitados[linha] = true;
                pilha.push(linha);
            }
        }
    }
    
    
    public static void main(String[] args) {
      
        Scanner n = new Scanner(System.in);
        int linha_coluna=0;
        String r;
        
        
        System.out.println("Digite a quantidade de linhas e coluna:\n");
        linha_coluna= n.nextInt();
        
        
        int matriz[][] = new int [linha_coluna][linha_coluna];
        
        for (int i = 0; i<linha_coluna;i++){
            for(int j = 0; j<linha_coluna; j++){
                matriz[i][j]=0;
            }
        }
        
        
         do{
             System.out.println("Digite a linha a ser alterada:\n");
             int linha= n.nextInt();
             
             System.out.println("Digite a coluna a ser alterada:\n");
             int coluna= n.nextInt();
             
             matriz[linha][coluna]=1;
             
             System.out.println("Deseja alterar mais alguma linha? (s ou n)\n");
             r=n.nextLine();
             
        }while(r== "s");
         
        
          for (int i = 0; i<linha_coluna;i++){
            for(int j = 0; j<linha_coluna; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    
    
    
}
