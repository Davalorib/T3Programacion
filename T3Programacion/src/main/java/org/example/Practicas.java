package org.example;

import java.util.Random;
import java.util.Scanner;

public class Practicas {

    public void prac1() {

        //el scanner para introducir cosas por teclado
        Scanner ent = new Scanner(System.in);
        //

        //todas mis variables y booleanos
        boolean valido;
        boolean valido2;
        int[] samuraisint = new int[7];
        int[] samurais1int = new int[7];
        int[] samurais2int = new int[7];
        int[] samuraisResta = new int[7];
        int[] samuraiscont = {1, 2, 3, 4, 5, 6, 7};
        String[] samuraissplit;
        int suma;
        int aux;
        int aux2;
        int samurais1cont = 0;
        int samurais2cont = 0;
        int restafinal;
        //

        //el random
        Random random = new Random();
        int numrandom = random.nextInt(7);
        //

        System.out.println("\n Introduce la potencia de tus 7 samurais separadas mediante una ','. Tienen que sumar 30 : ");

        //el for principal que hace 2 ciclos para formar los 2 equipos
        for (int n = 1; n <= 2; n++) {

            suma = 0; //reiniciamos suma
            System.out.println("> Equipo " + n);
            String samurais = ent.next(); //pedimos el equipo
            samuraissplit = samurais.split(","); //spliteamos las ','

            //inicializamos los booleanos como necesitemos
            valido = true;
            valido2 = false;
            //

            if (samuraissplit.length != 7) { //controlamos que el vector sea 7
                System.out.println("> ERROR... Escribe 7 potencias");
                n--; //reiniciamos el for
                continue; //volvemos al for
            }

            //for para ir convirtiendo los valores a int
            for (int i = 0; i < samuraissplit.length; i++) {

                //el try
                try {
                    samuraisint[i] = Integer.parseInt(samuraissplit[i]); //la conversion

                    //un if para controlar que el valor esté entre 1 y 24
                    if (samuraisint[i]<1 || samuraisint[i]>24){
                        System.out.println("> ERROR... Tu valor tiene que estar entre 1 y 24");
                        n--; //reiniciamos el for principal
                        valido = false; //cerramos el paso a las siguientes operaciones
                        break; //salimos del for
                    }
                    //

                //el catch controlando que se haya introducido un valor válido
                } catch (NumberFormatException er) {
                    System.out.println("> ERROR... Introduce nuevamente 7 potencias pero con número válidos");
                    n--; //reiniciamos el for principal
                    valido = false; //cerramos el paso a las siguientes operaciones
                    break; //salimos del for
                }
                //
            }
            //

            //condición para que haga lo de dentro si toodo lo anterior está perfecto (la palabra 't o d o' escrita junta hace algo extraño)
            if (valido) {
                for (int i = 0; i < samuraissplit.length; i++) { //for para ir sumando los valores de nuestro vector
                    suma += samuraisint[i]; //la suma
                }

                if (suma == 30) { //controlamos que la suma sea correcta
                    valido2 = true; //abrimos el paso a las siguiente operaciones

                } else { //si no es correcta la suma
                    System.out.println("> ERROR... La potencia total no suma 30");
                    System.out.println("> Introduce nuevamente 7 potencias pero que sumen 30");
                    n--; //reiniciamos el for principal
                    continue; //volvemos al for principal
                }
            }
            //

            //segunda condición para que haga lo de dentro si toodo lo anterior está perfecto
            if (valido2) {

                //for para mover el vector a la derecha las veces que nos haya salido en el random
                for (int i = 0; i < numrandom-1; i++) {
                    aux = samuraisint[0]; //el aux coge la primera posición para más tarde moverla al final
                    for (int l = 0; l < samuraisint.length - 1; l++) { //for para copiar el valor de la derecha del vector
                        samuraisint[l] = samuraisint[l + 1];
                    }
                    samuraisint[samuraisint.length - 1] = aux; //pegamos el aux en el último valor
                }
                //

                //un switch de n (que es la variable del ciclo for principal)
                switch (n) {
                    case 1: //si es 1 clonamos a una variable
                        samurais1int = samuraisint.clone();
                    case 2: //si es 2 clonamos a otra variable
                        samurais2int = samuraisint.clone();
                }
                //
            }
            //
        }
        //

        System.out.println("> Equipo completado.\n");
        System.out.println("> ¡Empieza la batalla!");
        System.out.println("> La batalla inicia con el Samurai "+ numrandom + ".");

        //este for vuelve a mover el vector a la derecha las veces que nos haya salido en el random pero de otro vector distinto que va del 1 al 7 para que nos diga los samurais que están luchando
        for (int i = 0; i < numrandom-1; i++) {
            aux2 = samuraiscont[0];
            for (int l = 0; l < samuraiscont.length - 1; l++) {
                samuraiscont[l] = samuraiscont[l + 1];
            }
            samuraiscont[samuraiscont.length - 1] = aux2;
        }
        //

        //for para ir mostrando resultados de peleas
        for (int i = 0; i < samurais1int.length; i++) {
            samuraisResta[i] = samurais1int[i] - samurais2int[i]; //una resta para saber quién ha ganado o si empatan

            //si es mayor que 0 ha ganado el equipo 1
            if (samuraisResta[i] > 0) {
                System.out.println("> Samurai "+ samuraiscont[i] +". Gana el Samurai del equipo 1. "+ samurais1int[i] +" vs "+ samurais2int[i]);
                samurais2int[i] = 0; //la potencia de esa posicion del equipo perdedor la igualamos a 0

            }
            //

            //si es menor que 0 ha ganado el equipo 2
            else if (samuraisResta[i] < 0) {
                System.out.println("> Samurai "+ samuraiscont[i] +". Gana el Samurai del equipo 2. "+ samurais1int[i] +" vs "+ samurais2int[i]);
                samurais1int[i] = 0; //la potencia de esa posicion del equipo perdedor la igualamos a 0
            }
            //

            //si ha perdido la ronda el equipo 1
            if (samurais1int[i] == 0) {
                samurais1cont++; //sumamos 1 a un contador

                //si ese contador supera la mitad de numeros que tiene el vector
                if (samurais1cont > samurais1int.length / 2){
                    break; //paramos las peleas porque ya sabemos el ganador
                }
                //
            }
            //

            //si ha perdido la ronda el equipo 2 lo mismo que con el equipo 1
            else if (samurais2int[i] == 0) {
                samurais2cont++;
                if (samurais2cont > samurais1int.length / 2){
                    break;
                }
            }
            //
        }
        //

        restafinal = samurais1cont - samurais2cont; //resta final para saber quíen ha ganado la batalla

        //si es mayor que 0 ha ganado el equipo 1
        if (restafinal > 0) {
            System.out.println("> ¡GANA EL EQUIPO 2! El equipo 1 ha tenido "+ samurais1cont +" bajas ");

        }
        //

        //si es menor que 0 ha ganado el equipo 2
        else if (restafinal < 0) {
            System.out.println("> ¡GANA EL EQUIPO 1! El equipo 2 ha tenido "+ samurais2cont +" bajas ");
        }
        //
    }

}