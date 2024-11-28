package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
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
                    if (samuraisint[i] < 1 || samuraisint[i] > 24) {
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
                for (int i = 0; i < numrandom - 1; i++) {
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
        System.out.println("> La batalla inicia con el Samurai " + numrandom + ".");

        //este for vuelve a mover el vector a la derecha las veces que nos haya salido en el random pero de otro vector distinto que va del 1 al 7 para que nos diga los samurais que están luchando
        for (int i = 0; i < numrandom - 1; i++) {
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
                System.out.println("> Samurai " + samuraiscont[i] + ". Gana el Samurai del equipo 1. " + samurais1int[i] + " vs " + samurais2int[i]);
                samurais2int[i] = 0; //la potencia de esa posicion del equipo perdedor la igualamos a 0

            }
            //

            //si es menor que 0 ha ganado el equipo 2
            else if (samuraisResta[i] < 0) {
                System.out.println("> Samurai " + samuraiscont[i] + ". Gana el Samurai del equipo 2. " + samurais1int[i] + " vs " + samurais2int[i]);
                samurais1int[i] = 0; //la potencia de esa posicion del equipo perdedor la igualamos a 0
            }
            //

            //si ha perdido la ronda el equipo 1
            if (samurais1int[i] == 0) {
                samurais1cont++; //sumamos 1 a un contador

                //si ese contador supera la mitad de numeros que tiene el vector
                if (samurais1cont > samurais1int.length / 2) {
                    break; //paramos las peleas porque ya sabemos el ganador
                }
                //
            }
            //

            //si ha perdido la ronda el equipo 2 lo mismo que con el equipo 1
            else if (samurais2int[i] == 0) {
                samurais2cont++;
                if (samurais2cont > samurais1int.length / 2) {
                    break;
                }
            }
            //
        }
        //

        restafinal = samurais1cont - samurais2cont; //resta final para saber quíen ha ganado la batalla

        //si es mayor que 0 ha ganado el equipo 1
        if (restafinal > 0) {
            System.out.println("> ¡GANA EL EQUIPO 2! El equipo 1 ha tenido " + samurais1cont + " bajas ");

        }
        //

        //si es menor que 0 ha ganado el equipo 2
        else if (restafinal < 0) {
            System.out.println("> ¡GANA EL EQUIPO 1! El equipo 2 ha tenido " + samurais2cont + " bajas ");
        }
        //
    }

    public void prac2() {
         //el scanner y el random
        Scanner ent = new Scanner(System.in);
        Random random = new Random();
        //
         //todas mis variables, vectores y booleanos
        boolean formato;
        boolean repetir = true;
        boolean complementofinal = true;
        String juego;
        String[] nums;
        int[] numsint = new int[7];
        int[] numsrandom = new int[6];
        int complement = random.nextInt(48)+1;
        int reintegro = random.nextInt(9);
        int aciertos = 0;
        //
         //texto de entrada al programa y pedida de numeros
        System.out.println("\n> BIENVENIDO A LA PRIMITIVA <");
        System.out.println(" ---------------------------");
        System.out.println("> Vas a elegir tus 6 números (1-49) separados entre sí con '-' y el reintegro separado con '/'");
        System.out.println("> Introduce tus números de la suerte con el formato adecuado: ");
        juego = ent.next();
        //
         //el .match este para asegurarnos de que se mete en el formato correcto
        formato = juego.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d");
        //
         //si el formato no es válido cerramos el programa con un return porque no hay nada después
        if (!formato) {
            System.out.println("> FORMATO NO VÁLIDO <");
            return;

        }
        //
         //spliteamos guiones y barras
        nums = juego.split("[-/]");
        //
         //un for para ir haciendo una secuencia de acciones y no repetir for's
        for (int n = 0; n < 3; n++) {
             //el for que hace toodo el programa
            for (int i = 0; i < nums.length - 1; i++) {
                 //switch con la n
                switch (n){
                     //si n=0
                    case 0:
                         //pasamos todos menos el reintegro a int
                        numsint[i] = Integer.parseInt(nums[i]);
                        //
                         // si hay alguno que no está en nuestro rango cerramos el programa
                        if (numsint[i] < 1 || numsint[i] > 49) {
                            System.out.println("> Tus valores tiene que estar entre 1 y 49 <");
                            return;
                        }
                        //
                        break;
                    //
                     //si n=1
                    case 1:
                         //ordenamos los números y cambiamos la i para que deje de dar vueltas
                        Arrays.sort(numsint);
                        i = 6;
                        //
                         //comprobamos si hay números repetidos y si es así cerramos el programa
                        for (int l = 0; l < numsint.length; l++) {
                            if (l!=numsint.length-1 && numsint[l]==numsint[l+1]){
                                System.out.println("> No puedes repetir números <");
                                return;
                            }
                        }
                        //
                        break;
                    //
                     //si n=2
                    case 2:
                        //creamos un vector de números random
                        numsrandom[i] = random.nextInt(48)+1;
                        //
                         //como nuestro vector es de 7 y solo hemos llenado 6, tenemos un 0 al principio, así que lo pongo al final
                        int aux;
                        aux = numsint[i];
                        numsint[i] = numsint[i + 1];
                        numsint[i + 1] = aux;
                        //
                        break;
                    //
                }
                //
            }
            //
        }
        //
         //meto en el último spot el reintegro de manera muy cutre para que no se ordene
        numsint[6] = Integer.parseInt(nums[6]);
        //
         //ordeno el vector de números random
        Arrays.sort(numsrandom);
        //
         //un bucle que busca repetidos y los recalcula en caso de haber hasta que sean todos distintos, lo mismo con el complementario
        while(repetir){
            repetir = false;
            for (int i = 0; i < numsrandom.length; i++) {
                if (i!=numsrandom.length-1 && numsrandom[i]==numsrandom[i+1]){
                    numsrandom[i] = random.nextInt(48)+1;
                    repetir = true;
                } else if (complement == numsrandom[i]) {
                    complement = random.nextInt(48) + 1;
                    repetir = true;
                    break;
                }
            }
            Arrays.sort(numsrandom);
        }
        //
         //un for que compara nuestros números con los del random y el complementario y nos suma los aciertos
        for (int i = 0; i < numsrandom.length; i++) {
            for (int j = 0; j < numsrandom.length; j++) {
                if (numsint[j] == numsrandom[i]){
                    aciertos++;
                }
            }
            if (complement == numsint[i]){
                complementofinal = false;
                break;
            }
        }
        //
         //toodo lo que se muestra por pantalla
        System.out.println("> Tus números:");
        System.out.println(Arrays.toString(numsint));
        System.out.println("\n> SORTEO <");
        System.out.println("----------");
        System.out.println(Arrays.toString(numsrandom));
        System.out.println("> El complementario: "+complement);
        System.out.println("> El reintegro: "+reintegro);
        System.out.println("\n> RESULTADOS <");
        System.out.println("--------------");
        System.out.println("> "+ aciertos +" "+ (aciertos == 1 ? "acierto" : "aciertos"));
        //
         //un último switch con la variable aciertos que clasifica nuestros aciertos en distintas categorías
        switch (aciertos){
            case 0,1,2:
                if (numsint[6] == reintegro){
                    System.out.println("> Reintegro");
                } else {
                    System.out.println("> No premiado");
                }
                break;
            case 3:
                System.out.println("> 5ª Categoría");
                break;
            case 4:
                System.out.println("> 4ª Categoría");
                break;
            case 5:
                if (!complementofinal){
                    System.out.println("> 2ª Categoría");
                } else {
                    System.out.println("> 3ª Categoría");
                }
                break;
            case 6:
                if (numsint[6] == reintegro){
                    System.out.println("> Categoría Especial");
                } else {
                    System.out.println("> 1ª Categoría");
                }
                break;
        }
        //
    }

    public void prac3() {

        Scanner ent = new Scanner(System.in);

        //todas mis variables, vectores, matrices y booleanos
        int gazpacho,manchego;
        int cuenta = 0;
        String palabra;
        String entrada;
        String[] filas;
        String[] palabrica;
        String eureka;
        String[][] matriz;
        boolean formato;
        //
        
         //el try
        try {
            System.out.println("Introduce las filas que quieres: ");
            gazpacho = ent.nextInt(); //pedimos el número de filas

            //si el número de filas es menor o igual que 0
            if (gazpacho <= 0) {
                System.err.println("Pero introduce un número válido."); //muestra por pantalla error
                return; //volvemos al main (en mi caso acaba el programa ya que no hay más en dicho main)
            }
            //

            System.out.println("Introduce las columnas que quieres: ");
            manchego = ent.nextInt(); //pedimos el número de columnas

            //si el número de columnas es menor o igual que 0
            if (manchego <= 0) {
                System.err.println("Pero introduce un número válido."); //muestra por pantalla error
                return; //volvemos al main
            }
            //
        }
        //
         //el catch
        catch (InputMismatchException er){
            System.err.println("Introduce un valor válido.");
            return; //volvemos al main
        }
        //

         //nuestra matriz en string y con el numero de filas y columnas previamente recogidos
        matriz = new String[gazpacho][manchego];

        //el for que va desde 0 hasta el tamanyo de nuestra matriz
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Introduce fila " + (i + 1) + ": "); //nos pide los valores de la fila por la que vaya el for
            entrada = ent.next(); //introducimos los valores

             //el .matches para asegurarnos que se introduce en el formato que nosotros queremos
            formato = entrada.matches("[a-zA-Z]+");
            //
             //si el formato no es el deseado
            if (!formato || entrada.length()!=manchego) {
                System.err.println("Utiliza unos datos válidos ("+ manchego +" letras)"); //nos muestra un error
                return; //volvemos al main
            }
            //

             //el .split para separar los caracteres y guardarlos en el vector filas
            filas = entrada.split("");
            //

             //un for para ir introduciendo el vector filas en la matriz
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=filas[j]; //igualamos la fila de la matriz al vector
            }
            //
        }
        //

        System.out.println();

        //recorremos la matriz para mostrarla por pantalla
        for(String[] i : matriz){
            for (String j : i){
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
        //

        System.out.println("\nIntroduce la palabra a buscar: ");
        palabra = ent.next(); //pedimos la palabra a buscar

        //otra vez el .matches con su respectivo if
        formato = palabra.matches("[a-zA-Z]+");

        if (!formato){
            System.err.println("Utiliza un formato válido");
            return;
        }
        //

        palabrica = palabra.split(""); //spliteamos y guardamos en un vector la palabra a buscar

        //2 for para recorrer la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                //si el caracter de la matriz en el que nos encontramos es igual al primer caracter de nuestra palabra a buscar (ignorando mayusculas y minusculas)
                if (matriz[i][j].equalsIgnoreCase(palabrica[cuenta])) {
                    int contador = j; //un contador para ir recorriendo cosas sin afectar al for principal
                    eureka = ""; //pues aqui voy a ir guardando el conjunto de letras para luego compararlo a la palabra a buscar

                     //el for para las palabras en horizontal
                    for (int k = 0; k < palabrica.length; k++) {
                        eureka += matriz[i][contador]; //vamos guardando en eureka las letras de la posicion en la matriz
                        contador++; //sumamos el contador

                        //si la palabra coincide con nuestra palabra a buscar (ignorando mayusculas y minusculas)
                        if(eureka.equalsIgnoreCase(palabra)){
                            System.out.println("Tu palabra está en horizontal, empezando en la "+ (i+1) +"ª fila, "+ (j+1) +"ª columna"); //te dice la posicion de tu palabra
                            return; //y acabamos el programa
                        }
                        //
                         //si el contador se sale de la matriz que deje de buscar porque no va a estar ahi
                        else if (contador >= matriz.length){
                            break;
                        }
                        //
                    }
                    //
                    contador = j; //reiniciamos contador
                    eureka = ""; //reiniciamos eureka

                    //el for para las palabras en horizontal invertidas
                    for (int k = 0; k < palabrica.length; k++) {
                        eureka += matriz[i][contador];
                        contador--;

                        if(eureka.equalsIgnoreCase(palabra)){
                            System.out.println("Tu palabra está en horizontal pero invertida, empezando en la "+ (i+1) +"ª fila, "+ (j+1) +"ª columna");
                            return;
                        } else if (contador<0){
                            break;
                        }
                    }
                    //
                    contador = i; //reiniciamos contador
                    eureka = ""; //reiniciamos eureka

                    //el for para las palabras en vertical
                    for (int k = 0; k < palabrica.length; k++) {
                        eureka += matriz[contador][j];
                        contador++;

                        if(eureka.equalsIgnoreCase(palabra)){
                            System.out.println("Tu palabra está en vertical, empezando en la "+ (i+1) +"ª fila, "+ (j+1) +"ª columna");
                            return;
                        } else if (contador >= matriz.length){
                            break;
                        }
                    }
                    //
                    contador = i; //reiniciamos contador
                    eureka = ""; //reiniciamos eureka

                    //el for para las palabras en horizontal pero invertidas
                    for (int k = 0; k < palabrica.length; k++) {
                        eureka += matriz[contador][j];
                        contador--;

                        if(eureka.equalsIgnoreCase(palabra)){
                            System.out.println("Tu palabra está en vertical pero invertida, empezando en la "+ (i+1) +"ª fila, "+ (j+1) +"ª columna");
                            return;
                        } else if (contador<0){
                            break;
                        }
                    }
                    //
                }
                //
            }
            //
        }
        //
        System.err.println("Esa palabra no está, no inventes."); //si llega aquí es porque no está la palabra
    }


}