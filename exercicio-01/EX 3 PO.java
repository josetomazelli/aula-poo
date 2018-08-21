{\rtf1\ansi\ansicpg1252\cocoartf1504\cocoasubrtf810
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww28600\viewh15520\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class Mes\{\
\
\
    public static void main(String[] args) \{\
       \
        Scanner s = new Scanner (System.in);\
        System.out.print("Digite um numero entre 1 e 12: ");\
        int i = s.nextInt();\
        String mes[] = \{"Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Desembro"\};\
        \
        if(i>=1 && i<=12)\{\
        switch (i)\{\
            case 1:\
                System.out.print(mes[0]);\
                break;\
            case 2:\
               System.out.print(mes[1]);\
                break;\
            case 3:\
                System.out.print(mes[2]);\
                break;\
            case 4:\
               System.out.print(mes[3]);\
                break;\
            case 5:\
                System.out.print(mes[4]);\
                break;\
            case 6:\
                System.out.print(mes[5]);\
                break;\
            case 7:\
                System.out.print(mes[6]);\
                break;\
            case 8:\
                System.out.print(mes[7]);\
                break;\
            case 9:\
                System.out.print(mes[8]);\
                break;\
             case 10:\
                System.out.print(mes[9]);\
                break; \
            case 11:\
                System.out.print(mes[10]);\
                break; \
            case 12:\
                System.out.print(mes[11]);\
                break;\
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