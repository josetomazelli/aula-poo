{\rtf1\ansi\ansicpg1252\cocoartf1504\cocoasubrtf810
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class Numeros\{\
\
   \
    public static void main(String[] args) \{\
       \
        Scanner s = new Scanner (System.in);\
        int i[]=new int[10];\
        int soma=0;\
        int menor=i[0];\
        int maior=i[0];\
        int media=0;\
        \
        for (int j=0;j<10;j++)\{\
        System.out.printf("Informe %2do. valor de %d: ", (j+1), 10);\
        i[j] = s.nextInt();\
        soma=soma+i[j];\
        \
        if (i[j] < menor)\
         menor = i[j];\
        \
        if (i[j] > maior)\
         maior = i[j];\
        \
        \}\
        System.out.printf("\\n");\
        \
        for (int a=0; a<10; a++) \{\
      if (i[a] == menor)\
        System.out.printf("v[%d] = %2d <--- menor valor\\n", a, i[a]);\
      else if (i[a] == maior)\
              System.out.printf("v[%d] = %2d <--- maior valor\\n", a, i[a]);\
           else System.out.printf("v[%d] = %2d\\n", a, i[a]);\
    \}\
    media=soma/10;\
    \
    System.out.printf("\\nSoma = %d\\n", soma);\
    System.out.printf("\\nMedia = %d\\n", media);\
  \}\
 \}\
}