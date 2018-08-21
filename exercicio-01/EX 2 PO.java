{\rtf1\ansi\ansicpg1252\cocoartf1504\cocoasubrtf810
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww28600\viewh15520\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class Dias \{\
\
     \{\
       \
        Scanner s = new Scanner (System.in);\
        System.out.print("Digite um numero entre 1 e 7: ");\
        int i = s.nextInt();\
        \
        if(i>=1 && i<=7)\{\
        switch (i)\{\
            case 1:\
                System.out.print("Domingo");\
                break;\
            case 2:\
                System.out.println("Segunda-feira");\
                break;\
            case 3:\
                System.out.println("Terca-feira");\
                break;\
            case 4:\
                System.out.println("Quata-feira");\
                break;\
            case 5:\
                System.out.println("Quinta-feira");\
                break;\
            case 6:\
                System.out.println("Sexta-feira");\
                break;\
            case 7:\
                System.out.println("Segunda");\
                \
            default:\
        \}\
    \}else \{\
            System.out.print("Valor invalido");\
        \}\
        \
    \}\
    \
\}\
}