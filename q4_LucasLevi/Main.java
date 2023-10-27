package q4_LucasLevi;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrixA = randomMatrix(3, 4);
        int[][] matrixB = randomMatrix(4, 2);

        int[][] result = multiply(matrixA, matrixB);

        System.out.println("Matriz A:");
        printMatrix(matrixA);
        System.out.println("\nMatriz B:");
        printMatrix(matrixB);

        System.out.println("\nResultado da Multiplicação:");
        printMatrix(result);
    }
    public static int[][] randomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}