package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrices {

    public void matrices1(){

        int matriz[][] = new int[3][3];

        for (int i=0; i<matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("\nMatriz 2");

        int matriz2[][] = {{2,3,5,1},{5,10,32,6}};

        for (int[] fila : matriz2){
            System.out.println(Arrays.toString(fila));
        }

        int matriz3[][] = new int[3][3];
        Scanner ent = new Scanner(System.in);

        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3.length; j++) {

                System.out.println("Introduce la posición ("+ i +","+ j +")");
                matriz3[i][j] = ent.nextInt();

            }
        }

        System.out.println("Tu matriz queda: ");
        for (int i=0; i<matriz3.length; i++){
            for (int j = 0; j < matriz3[i].length; j++) {
                System.out.print(matriz3[i][j]+ " ");
            }
            System.out.println();
        }


    }

    public void matrices2(){

        int m[][] = new int[3][3];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                if (i==j) {
                    m[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                if (m[i][j]==1) {
                    System.out.print("X");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    public void buscar(){

        Random random = new Random();

        int[][] matriz = new int[2][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(10);
            }
        }

        for (int[] filas:matriz){
            for (int columnas : filas){
                System.out.print(columnas +" ");
            }
            System.out.print("\n");
        }

        final int num = 8;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == num) {
                    System.out.println("Existe, piola");
                    return;
                }
            }
        }
        System.out.println("No existe, piolan't");

    }

    public void bat1(){

        Scanner ent = new Scanner(System.in);
        Random random = new Random();
        int a,b;
        int suma = 0;
        int columna = 0;
        int a1,b1;
        int suma1 = 0;
        int columna1 = 0;

        System.out.println("Introduce las filas que quieres: ");
        a = ent.nextInt();
        System.out.println("Introduce las columnas que quieres: ");
        b = ent.nextInt();
        int[][] matriz3 = new int[a][b];

        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3[i].length; j++) {
                System.out.println("Introduce la posición ("+ i +","+ j +")");
                matriz3[i][j] = ent.nextInt();

            }
        }

        System.out.println("\nTu matriz: ");
        for (int i=0; i<matriz3.length; i++){
            for (int j = 0; j < matriz3[i].length; j++) {
                System.out.print(matriz3[i][j]+ " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3[i].length; j++) {
                suma += matriz3[i][j];
            }
            System.out.println("La suma de tu fila "+ (i+1) +" "+ suma);
            suma = 0;
        }

        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3[i].length; j++) {
                columna += matriz3[j][i];
            }
            System.out.println("La suma de tu columna "+ (i+1) +" "+ columna);
            columna = 0;
        }

        System.out.println("\nIntroduce las filas que quieres en la random: ");
        a1 = ent.nextInt();
        System.out.println("Introduce las columnas que quieres: ");
        b1 = ent.nextInt();
        int[][] matriz = new int[a1][b1];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(10);
            }
        }

        System.out.println("\nTu matriz: ");
        for (int i=0; i<matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
            suma1 += matriz[i][j];
            }
            System.out.println("La suma de tu fila "+ (i+1) +" "+ suma1);
            suma1 = 0;
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                columna1 += matriz[j][i];
            }
            System.out.println("La suma de tu columna "+ (i+1) +" "+ columna1);
            columna1 = 0;
        }

    }

    public void calentar() {

        Scanner ent = new Scanner(System.in);
        Random random = new Random();

        int a;
        int b;
        int l0 = 0,l1 = 0, l2 = 0;
        int[][] matriz1 = null;
        int[][] matriz2 = null;
        int[][] matriz;

        for (int i = 0; i < 2; i++) {
            System.out.println("Matriz " + i);
            System.out.println("Dime cuantas filas quieres: ");
            a = ent.nextInt();
            System.out.println("Dime cuantas columnas quieres: ");
            b = ent.nextInt();

            matriz = new int[a][b];

            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz[i].length; k++) {
                    matriz[j][k] = random.nextInt(10);
                    l0 = matriz[j][k];
                }
            }

            switch (i) {
                case 0:
                    matriz1 = matriz.clone();
                    l1 = l0;
                    break;

                case 1:
                    matriz2 = matriz.clone();
                    l2 = l0;
                    break;
            }

        }

        if (l1 != l2) {
            System.out.println("Los tamaños tienen que ser iguales ");
            return;
        }

        for (int[] filas : matriz1) {
            for (int columnas : filas) {
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        for (int[] filas : matriz2) {
            for (int columnas : filas) {
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }

    }  


}
