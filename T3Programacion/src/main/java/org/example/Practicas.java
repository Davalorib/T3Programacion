package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practicas {

    public void prac1() {

        Scanner ent = new Scanner(System.in);

        boolean valido;
        boolean valido2;
        boolean si;
        int[] samuraisint = new int[7];
        int[] samurais1int = new int[7];
        int[] samurais2int = new int[7];
        String[] samuraissplit;

        Random random = new Random();

        int numrandom = random.nextInt(7);
        int aux = 0;

        System.out.println("\n Introduce la potencia de tus 7 samurais separadas mediante una ','. Tienen que sumar 30 : ");

        for (int n = 1; n <= 2; n++) {
            System.out.println("> Equipo " + n);
            String samurais = ent.next();
            samuraissplit = samurais.split(",");

            if (samuraissplit.length != 7) {
                System.out.println("> ERROR... Escribe 7 potencias");
                n--;
                continue;
            }

            valido = true;
            for (int i = 0; i < samuraissplit.length; i++) {
                try {
                    samuraisint[i] = Integer.parseInt(samuraissplit[i]);
                } catch (NumberFormatException er) {
                    System.out.println("> ERROR... Introduce nuevamente 7 potencias pero con número válidos");
                    n--;
                    valido = false;
                    break;
                }
            }

            valido2 = true;
            if (valido) {
                int suma = 0;
                for (int i = 0; i < samuraissplit.length; i++) {
                    suma += samuraisint[i];
                }
                if (suma != 30) {
                    System.out.println("> ERROR... La potencia total no suma 30");
                    System.out.println("> Introduce nuevamente 7 potencias pero que sumen 30");
                    n--;
                    valido2 = false;
                    continue;
                }
            }

            for ( int i=0; i<numrandom; i++ ) {
                aux = samuraisint[i];
                samuraisint[i] = samuraisint[samuraisint.length-i-1];
                samuraisint[samuraisint.length-i-1] = aux;
            }

            if (valido2) { //si no pongo esta verificacion previa se me clona el primero si el segundo lo hago mal
                switch (n) {
                    case 1:
                        samurais1int = samuraisint.clone();
                    case 2:
                        samurais2int = samuraisint.clone();
                }
            }
        }



        System.out.println(Arrays.toString(samurais1int));
        System.out.println(Arrays.toString(samurais2int));

    }

}
