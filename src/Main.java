public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("USAGE: java AnyaLab2 <VECTOR_SIZE> <ROW_NUM> <COL_NUM>");
            System.exit(0);
        }

        int vectorSize = Integer.parseInt(args[0]);
        int matrixRows = Integer.parseInt(args[1]);
        int matrixColumns = Integer.parseInt(args[2]);

        if (vectorSize != matrixRows) {
            System.out.println("Vector size must equal matrix rows!");
            System.exit(0);
        }

        double[][] vector = new double[1][vectorSize];

        double[][] matrix = new double[matrixRows][matrixColumns];

        // Заповнення вектора
        for (int i = 0; i < vector[0].length; i++) {
            vector[0][i] = Math.random();
        }

        // Заповнення матриці
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.random();
            }
        }

        System.out.println("Vector:");
        printMatrix(vector);

        System.out.println("Matrix:");
        printMatrix(matrix);

        double[][] result = multiplyMatrices(vector, matrix);

        System.out.println("Result (Vector × Matrix):");
        printMatrix(result);
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.4f ", value);
            }
            System.out.println();
        }
    }

    static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {

        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyCell(firstMatrix, secondMatrix, row, col);
            }
        }

        return result;
    }

    static double multiplyCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {

        double cell = 0;

        for (int i = 0; i < firstMatrix[0].length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }

        return cell;
    }
}