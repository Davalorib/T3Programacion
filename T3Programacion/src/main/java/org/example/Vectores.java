package org.example;

import java.util.Random;
import java.util.Scanner;

public class Vectores {

    public void vector(){

        int vector[];
        vector = new int[7];

        vector[2] = 7;
        vector[5] = vector[2]+4;

        System.out.println(vector[2] +" "+ vector[5]);

        for (int i=0; i<vector.length; i++){
            System.out.print(" " +vector[i]+ " ");
        }

        String palabras[] = new String[3];
        palabras[0]= "Pepe";

        for (int i=0; i< palabras.length; i++){
            System.out.print(" "+ palabras[i] +" ");
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

    public void ej2(){

        Scanner ent = new Scanner(System.in);
        int nums[] = new int[5];

        System.out.println("Introduce los números a invertir...");

        for (int i : nums){

            nums[i] = ent.nextInt();

        }

        for (int i= nums.length-1; i>=0; i--){
            System.out.println(" "+ nums[i] +" ");
        }

    }

    public void ej3(){

        

    }
}