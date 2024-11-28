package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Olimpiadas {

    public void hyperpar() {

        Scanner ent = new Scanner(System.in);

        String a;
        String[] b;

        System.out.println("dame el numero");
        a = ent.next();

        b = a.split("");
        int[] bint = new int[b.length];

        System.out.println(Arrays.toString(b));

        for (int i = 0; i < b.length; i++) {
            try {
                bint[i] = Integer.parseInt(b[i]);

            } catch (NumberFormatException er) {
                System.err.println("> ERROR... Introduce un número entero positivo");
                return;

            }

            if (bint[i]%2 != 0) {
                System.out.println("tu numero no es hyperpar");
                return;
            }
        }
        System.out.println("si es ");
    }

    public void saltosMario(){

        Scanner ent = new Scanner(System.in);

        int num;
        int contmas=0;
        int contmenos=0;
        String a;
        String[] roberto;

        System.out.println("dame el numero de muros");

        try {
            num = ent.nextInt();
            ent.nextLine();

        } catch (InputMismatchException er) {
            System.err.println("> ERROR... Introduce un número entero positivo");
            return;

        }

        if (num>10 || num<0){
            System.err.println("que no");
            return;
        }

        System.out.println("dame los muros");
        a = ent.nextLine();
        roberto = a.split(" ");
        System.out.println(Arrays.toString(roberto));

        if (roberto.length != num){
            System.err.println("que no es igual");
            return;
        }

        int[] mauro = new int[roberto.length];

        for (int i = 0; i < num; i++) {
            try {
                mauro[i] = Integer.parseInt(roberto[i]);

            } catch (NumberFormatException er) {
                System.err.println("> ERROR... Introduce un número entero positivo");
                return;

            }

        }

        for (int i = 0; i < mauro.length-1; i++) {
            if (mauro[i] > mauro[i + 1]) {
                contmenos++;
            } else if (mauro[i] < mauro[i + 1]) {
                contmas++;
            }
        }

        System.out.println("subes "+contmas);
        System.out.println("bajas "+contmenos);
    }

}
