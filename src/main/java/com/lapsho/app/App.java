package com.lapsho.app;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    /**
     * The constant NULL_INSTEAD_MATRIX_EXCEPTION_MESSAGE.
     */
    public final static String NULL_INSTEAD_MATRIX_EXCEPTION_MESSAGE = "null value provided instead of matrix input";
    /**
     * The constant NULL_INSTEAD_MATRIX_ROW_EXCEPTION_MESSAGE.
     */
    public final static String NULL_INSTEAD_MATRIX_ROW_EXCEPTION_MESSAGE = "null value as a matrix row provided";
    /**
     * The constant INVALID_MATRIX_PROPORTION_EXCEPTION_MESSAGE.
     */
    public final static String INVALID_MATRIX_PROPORTION_EXCEPTION_MESSAGE = "Invalid matrix proportion provided: ";

    /**
     * Determinant int.
     *
     * @param matrix the matrix
     * @return the int
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static int determinant(int[][] matrix) throws IllegalArgumentException {
        validateInput(matrix);
        int determinant;

        switch (matrix.length) {
            case 1:
                determinant = matrix[0][0];
                break;
            case 2:
                determinant = calculateN2Matrix(matrix);
                break;
            default:
                determinant = calculateComplexMatrix(matrix);
        }

        return determinant;
    }

    private static void validateInput(int[][] matrix) throws IllegalArgumentException {
        if (matrix == null) {
            throw new IllegalArgumentException(NULL_INSTEAD_MATRIX_EXCEPTION_MESSAGE);
        }

        int matrixSize = matrix.length;
        Arrays.stream(matrix).forEach(row -> {
            if (row == null) {
                throw new IllegalArgumentException(NULL_INSTEAD_MATRIX_ROW_EXCEPTION_MESSAGE);
            }

            if (row.length != matrixSize) {
                throw new IllegalArgumentException(INVALID_MATRIX_PROPORTION_EXCEPTION_MESSAGE);
            }
        });
    }

    private static int calculateComplexMatrix(int[][] matrix) {
        return 0;
    }

    private static int calculateN2Matrix(int[][] matrix) {
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }
}
