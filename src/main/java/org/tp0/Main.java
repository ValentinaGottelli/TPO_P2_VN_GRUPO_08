package org.tp0;

import org.tp0.implementations.QueueOfStacks;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Ejercicio 3");
            System.out.println("4. Ejercicio 4");
            System.out.println("5. Ejercicio 5");
            System.out.println("6. Ejercicio 6");
            System.out.println("7. Exit");
            System.out.print("Elija la opcion del 1 al 7: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Eligio el Ejercicio 1");
                    System.out.printf("");

                    System.out.printf("Calculo de traza" + "\n");
                    System.out.println(QueueOfStacks.resolucionTraza());
                    System.out.printf("");

                    System.out.printf("Traspuesta de la matriz" + "\n");
                    QueueOfStacks.imprimirMatrix(QueueOfStacks.traspuesta());
                    System.out.printf("");

                    System.out.printf("Suma matricial"+ "\n");
                    QueueOfStacks.imprimirMatrix(QueueOfStacks.sumaMatrices());

                    break;
                case 2:
                    System.out.println("Eligio el Ejercicio 2");

                    break;
                case 3:
                    System.out.println("Eligio el Ejercicio 3");

                    break;
                case 4:
                    System.out.println("Eligio el Ejercicio 4");

                    break;
                case 5:
                    System.out.println("Eligio el Ejercicio 5");

                    break;
                case 6:
                    System.out.println("Eligio el Ejercicio 6");

                    break;
                case 7:
                    System.out.println("Cerrando...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 7);

        scanner.close();

    }
}