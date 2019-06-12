/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavalo;

/**
 *
 * @author josegabrieltomazellisilva
 */
public class Cavalo {
    private int contador = 1; //Conta o número de casas.
    private int moveNumber = 0; //Índice dos arrays h e v.
    private int coorX = 0; //Linha da posicao atual do cavalo.
    private int coorY = 0; //Coluna da posicao atual do cavalo.
    int[] h = {2, 1, -1, -2, -2, -1, 1, 2};//Movimento horizontal do cavalo.
    int[] v = {-1, -2, -2, -1, 1, 2, 2, 1};//Movimento vertical do cavalo.
    private int[][] board = new int[8][8];//Tabuleiro do passeio do cavalo.
    //
    public void Passeio()
    {
        board[coorX][coorY] = 1; 
        while(true)
        {
            if( (coorX + v[moveNumber] >=0 && coorY + h[moveNumber] >= 0) && 
                    (coorX + v[moveNumber] <=7 && coorY + h[moveNumber] <= 7))
            {
                if(board[coorX + v[moveNumber]][coorY + h[moveNumber]] == 0)
                {
                    coorX = coorX + v[moveNumber];
                    coorY = coorY + h[moveNumber];  
                    board[coorX][coorY] = ++contador;
                }
            }
            moveNumber++;
            if(moveNumber > 7)
                moveNumber = 0;
            if (contador == 64)
                break;
            Tabuleiro();
        }
    }
    //
    public void Tabuleiro()
    {
        for(int i=0; i< board.length; i++)
        {
            System.out.println();
            for(int j=0; j< board[i].length; j++)
                System.out.printf("\t%d ",board[i][j]);
        }
        System.out.println();
    }

   
    public static void main(String[] args) {
        Cavalo cavalo = new Cavalo();
        cavalo.Passeio();
    }
    
}
