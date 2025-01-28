
import java.util.Random;
public class MatrixOperations {
    public static void main(String[] args) {
        int rows = 3, cols = 3;
        int[][] matrixA = createRandomMatrix(rows, cols);
        int[][] matrixB = createRandomMatrix(rows, cols);
        System.out.println("Matrix A:");
        displayMatrix(matrixA);
        System.out.println("Matrix B:");
        displayMatrix(matrixB);
        System.out.println("\nMatrix A + Matrix B:");
        int[][] sum = addMatrices(matrixA, matrixB);
        displayMatrix(sum);
        System.out.println("\nMatrix A - Matrix B:");
        int[][] difference = subtractMatrices(matrixA, matrixB);
        displayMatrix(difference);
        System.out.println("\nMatrix A * Matrix B:");
        int[][] product = multiplyMatrices(matrixA, matrixB);
        displayMatrix(product);
        System.out.println("\nTranspose of Matrix A:");
        int[][] transposeA = transposeMatrix(matrixA);
        displayMatrix(transposeA);
        System.out.println("\nDeterminant of Matrix A:");
        System.out.println(determinant(matrixA));
        System.out.println("\nInverse of Matrix A:");
        double[][] inverseA = inverse(matrixA);
        if (inverseA != null) {
            displayMatrix(inverseA);
        } else {
            System.out.println("Matrix A has no inverse.");
        }
    }
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random number between 0 and 9
            }
        }
        return matrix;
    }
    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }
    public static int[][] subtractMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible due to incompatible dimensions.");
            return null;
        }
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    public static int determinant(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else if (rows == 3) {
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                    - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                    + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }
        return 0;
    }
    public static double[][] inverse(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 2) {
            int det = determinant(matrix);
            if (det == 0) {
                return null; // No inverse exists
            }
            double[][] inverseMatrix = new double[2][2];
            inverseMatrix[0][0] = matrix[1][1] / (double) det;
            inverseMatrix[0][1] = -matrix[0][1] / (double) det;
            inverseMatrix[1][0] = -matrix[1][0] / (double) det;
            inverseMatrix[1][1] = matrix[0][0] / (double) det;
            return inverseMatrix;
        } else if (rows == 3) {
            int det = determinant(matrix);
            if (det == 0) {
                return null;
            }
            double[][] adjointMatrix = new double[3][3];
            adjointMatrix[0][0] = matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1];
            adjointMatrix[0][1] = matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2];
            adjointMatrix[0][2] = matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1];
            adjointMatrix[1][0] = matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2];
            adjointMatrix[1][1] = matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0];
            adjointMatrix[1][2] = matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2];
            adjointMatrix[2][0] = matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0];
            adjointMatrix[2][1] = matrix[0][1] * matrix[2][0] - matrix[0][0] * matrix[2][1];
            adjointMatrix[2][2] = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            double[][] inverseMatrix = new double[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    inverseMatrix[i][j] = adjointMatrix[i][j] / det;
                }
            }
            return inverseMatrix;
        }
        return null;
    }
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void displayMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%.2f", matrix[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}

