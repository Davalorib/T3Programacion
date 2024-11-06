package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Vectores {

    public void vector() {

        int vector[];
        vector = new int[7];

        vector[2] = 7;
        vector[5] = vector[2] + 4;

        System.out.println(vector[2] + " " + vector[5]);

        for (int i = 0; i < vector.length; i++) {
            System.out.print(" " + vector[i] + " ");
        }

        String palabras[] = new String[3];
        palabras[0] = "Pepe";

        for (int i = 0; i < palabras.length; i++) {
            System.out.print(" " + palabras[i] + " ");
        }
    }

    public void ej1() {

        Random random = new Random();

        int nums[] = new int[8];
        int suma = 0;

        for (int i : nums) {
            try {
                nums[i] = random.nextInt(501);
                suma += nums[i];
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers.");
            }
        }

        System.out.println("La suma de los elementos es: " + suma);

    }

    public void ej2() {

    Scanner ent = new Scanner(System.in);
    int nums[] = new int[5];

    System.out.println("Introduce los números a invertir...");

    for (int i = 0; i < nums.length; i++) {
        boolean valido = true;
        while (valido) {
            try {
                nums[i] = ent.nextInt();
                valido = false;
            } catch (InputMismatchException er) {
                System.out.println("ERROR... INTRODUCE UN NUMERO VALIDO");
                ent.nextLine();
            }
        }
    }

    int tam_mitad = nums.length / 2;
    int aux = 0;

    for ( int i=0; i<tam_mitad; i++ ) {

        aux = nums[i];
        nums[i] = nums[nums.length-i-1];
        nums[nums.length-i-1] = aux;
    }

//        for (int i = nums.length - 1; i >= 0; i--) {
//            System.out.print(" " + nums[i] + " ");
//        }
//
    }

    public void ej5 () {

        Scanner ent = new Scanner(System.in);

        int vector[] = new int[5];


        int ultima_posicion = vector[vector.length - 1];

        for (int i = 0; i < vector.length; i++) {
            boolean valido = true;
            while (valido) {
                try {
                    System.out.println("Introduce un número");
                    vector[i] = ent.nextInt();
                    valido = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error");
                    ent.nextLine();
                }
            }

        }

        for (int i = vector.length - 1; i >= 0; i--) {

            if (i == 0) {
                vector[i] = ultima_posicion;

            } else {
                vector[i] = vector[i - 1];
            }
            System.out.println(vector[i] + " ");
        }

    }

    public void vectores2() {

        String palabras[] = {"Paco", "Pepe", "Juan", "Maria"};

        for(String i : palabras){

            System.out.print(i+ " ");

        }

        String texto_vector = Arrays.toString(palabras);
        System.out.println("\n"+ texto_vector);

        String palabras2[] = palabras;

        palabras2[0] = "Francisco";

        System.out.println(palabras);
        System.out.println(palabras2);
        System.out.println(Arrays.toString(palabras));
        System.out.println(Arrays.toString(palabras2));

        String palabras3[] = palabras.clone();
        palabras3[1] = "Lourdes";
        System.out.println(palabras3);
        System.out.println(Arrays.toString(palabras3));

        String nombres_chachis[] = new String[2];
        System.arraycopy(palabras, 0, nombres_chachis, 0, 2);
        System.out.println(Arrays.toString(nombres_chachis));


    }


}