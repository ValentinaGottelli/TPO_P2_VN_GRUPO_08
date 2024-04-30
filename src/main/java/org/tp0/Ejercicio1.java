package org.tp0;

import java.util.Scanner;

public class Ejercicio1 {

    public static Scanner scanner = new Scanner(System.in);

    private static int[][] createMatrix(int filas, int columnas) {

        int[][] matrix = new int[filas][columnas];

        System.out.println("Ingrese los numeros de su matriz:");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese un numero en la posicion (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static int resolucionTraza() {
        System.out.print("Ingrese el numero de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el numero de columnas: ");
        int columnas = scanner.nextInt();
        int[][] matriz = createMatrix(filas, columnas);
        int n = matriz.length;
        int trace = 0;

        for (int i = 0; i < n; i++) {
            trace += matriz[i][i];
        }

        int complejidad = (filas * columnas) + Math.max(filas, columnas);
        System.out.println("Complejidad compuacional de: " + "O(" + complejidad + ")" + "\n");
        return trace;
    }

    public static int[][] traspuesta() {
        System.out.print("Ingrese el numero de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el numero de columnas: ");
        int columnas = scanner.nextInt();
        int[][] matriz = createMatrix(filas, columnas);

        int[][] traspuesta = new int[columnas][filas]; //O(1)

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }

        System.out.println("Complejidad compuacional de: " + "Complejidad total ≈ O(1)" + "\n");

        return traspuesta;
    }

    public static int[][] sumaMatrices() {
        System.out.print("Ingrese el numero de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el numero de columnas: ");
        int columnas = scanner.nextInt();
        int[][] matriz1 = createMatrix(filas, columnas);
        int[][] matriz2 = createMatrix(filas, columnas);

        int[][] sum = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sum[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        int complejidad = (filas * columnas);
        System.out.println("Complejidad compuacional de: " + "O(" + complejidad + ")" + "\n");
        return sum;
    }

    public static void imprimirMatrix(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
