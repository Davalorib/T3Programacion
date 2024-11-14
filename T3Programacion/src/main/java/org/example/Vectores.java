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

    public void navidad(){

        Scanner ent = new Scanner(System.in);

        String resultado = "";
        final String palabra = "NAVIDAD";

        System.out.println("dame el vector");
        String vecveces = ent.nextLine();

        String cantidades[] = vecveces.split(" ");
        String letras[] = palabra.split("");

        for (int i=0; i< letras.length; i++){

            for (int j=0 ; i<=Integer.parseInt(cantidades[i]) ; j++){

                resultado += letras[i];

            }

        }

        System.out.println(resultado);

    }

    public void prueba_buscar(){

        String colores[] = {"amarillo","azul","rojo","naranja"};
        String color = "negro";

        boolean existe = Arrays.asList(colores).contains(color);

        if (existe){
            System.out.println("Los negros cuentan ");
        } else {
            System.out.println("Los negros no cuentan ");
        }

    }

    public void ruleta(){

        Scanner ent = new Scanner(System.in);
        Random random = new Random();

        String colores[] = {"rojo","negro"};
        Integer numeros[] = new Integer[37];

        for (int i=0; i< numeros.length; i++){
            numeros[i] = i;
        }

        String pares[] = {"par","impar"};

        System.out.println("Número (0-36): ");
        int numero = ent.nextInt();

        boolean numero_existe = Arrays.asList(numeros).contains(numero);
        String color = "";
        String par = "";

        if (!numero_existe){

            System.out.println("ERROR. El número no es válido.");
            return;

        } else {
            if (numero!=0){
                System.out.println("Color (rojo/negro): ");
                color = ent.next();

                boolean color_existe = Arrays.asList(colores).contains(color);

                if (!color_existe){

                    System.out.println("ERROR. El color no es válido.");
                    return;

                } else {

                    System.out.println("Introduce la opción par o impar");
                    par = ent.next();

                    boolean par_existe = Arrays.asList(pares).contains(par);

                    if (!par_existe) {

                        System.out.println("ERROR. La opción par/impar no es válida.");
                        return;

                    }
                }
            }


        }

        String pares_sorteo;

        int num_sorteo = numeros[random.nextInt(37)];
        String color_sorteo = colores[random.nextInt(2)];

        if (num_sorteo%2==0){

            pares_sorteo = "par";

        } else {

            pares_sorteo = "par";

        }

        //faltan los premios
        if(numero!=0 && num_sorteo==numero && color_sorteo.equals(color) && pares_sorteo.equals((pares))){
            System.out.println("HAS GANADO");
        } else if (numero!=0 && color_sorteo.equals(color)){
            System.out.println("Has acertado el color.");
        } else if (numero!=0 && pares_sorteo.equals(par)) {
            System.out.println("Has acertado la opción par/impar");
        } else if (numero!=0 && numero==num_sorteo) {
            System.out.println("Has acertado el número");
        } else if (numero==0 && num_sorteo==0){
            System.out.println("HAS GANADO Y LOS DEMÁS PARGUELAS PIERDEN");
        } else {
            System.out.println("Has perdido");
        }
    }

    public void ordenar(){

        int[] nums = {4,3,10,34,21};
        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int num1 = 20;

        int posicion = Arrays.binarySearch(nums,num1);
        System.out.println(posicion);

        //el binary hecho con codigo pero solo si esta, si no esta se queda infinito que no me da tiempo a hacer eso
        int aux;
        int aux2;
        int i = 0;
        do {
            aux = (i + (nums.length-1)) / 2;
            aux2 = nums[aux];
            i = aux+1;
        }while(aux2!=num1);
        System.out.println(aux);
        //
    }
}