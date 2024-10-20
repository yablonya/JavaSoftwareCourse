import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            byte[][] matrix1 = {
                    {1, 40, 2},
                    {16, 12, 6},
                    {7, 5, 9}
            };

            byte[][] matrix2 = {
                    {9, 8, 7},
                    {6, 5, 4},
                    {3, 2, 1}
            };

            if (!isSameSize(matrix1, matrix2)) {
                throw new IllegalArgumentException("Матриці мають різні розміри.");
            }

            byte[][] resultMatrix = addMatrices(matrix1, matrix2);

            System.out.println("Результат додавання матриць:");
            printMatrix(resultMatrix);

            int sumOfMinElements = sumOfMinColumnElements(resultMatrix);

            System.out.println("Сума найменших елементів кожного стовпця: " + sumOfMinElements);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Невідома помилка: " + e.getMessage());
        }
    }

    private static boolean isSameSize(byte[][] matrix1, byte[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
        }

        return true;
    }

    private static byte[][] addMatrices(byte[][] matrix1, byte[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        byte[][] result = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (byte) (matrix1[i][j] + matrix2[i][j]);
            }
        }

        return result;
    }

    private static int sumOfMinColumnElements(byte[][] matrix) {
        int cols = matrix[0].length;
        int sum = 0;

        for (int j = 0; j < cols; j++) {
            int minElement = Byte.MAX_VALUE;
            for (byte[] bytes : matrix) {
                if (bytes[j] < minElement) {
                    minElement = bytes[j];
                }
            }
            sum += minElement;
        }

        return sum;
    }

    private static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}