public class ass1q4 {
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        if (cols1 != matrix2.length) {
            System.out.println("Matrix multiplication not possible");
            return null;
        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("Original array:");
        printArray(arr);
        reverseArray(arr);
        System.out.println("Reversed array:");
        printArray(arr);

        int[][] matrix1 = { { 1, 2 }, { 3, 4 } };
        int[][] matrix2 = { { 5, 6 }, { 7, 8 } };
        System.out.println("\nMatrix Multiplication Result:");
        int[][] multiplied = multiplyMatrix(matrix1, matrix2);
        printMatrix(multiplied);

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println("\nOriginal Matrix:");
        printMatrix(matrix);
        System.out.println("\nTransposed Matrix:");
        printMatrix(transposeMatrix(matrix));
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
