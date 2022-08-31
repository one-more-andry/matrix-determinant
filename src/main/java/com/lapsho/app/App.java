package com.lapsho.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private static int calculateN2Matrix(int[][] matrix) {
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    private static int calculateComplexMatrix(int[][] matrix) {
        int i = 0, determinant = 0;

        while (i < matrix[0].length) {
            int subDeterminant = matrix[0][i] * determinant(extractMinorMatrix(matrix, i));

            if (i == 0) {
                determinant = subDeterminant;

            } else if (i % 2 == 0) {
                determinant += subDeterminant;

            } else {
                determinant -= subDeterminant;
            }

            i++;
        }

        return determinant;
    }

    private static int[][] extractMinorMatrix(int[][] matrix, int columnIndex) {
        if (matrix.length < 3) {
            return matrix;
        }

        int limit = matrix.length - 1;
        int[][] minorMatrix = new int[limit][limit];

        for (int i = 1; i <= limit; i++) {
            int[] rowSequence = new int[limit];

            if (i == 0) {
                rowSequence = Arrays.copyOfRange(matrix[i], 1, matrix[i].length);

            } else if (i == matrix.length) {
                rowSequence = Arrays.copyOfRange(matrix[i], 0, matrix[i].length - 1);

            } else {
                int[] pre = Arrays.copyOfRange(matrix[i], 0, columnIndex);
                System.arraycopy(pre, 0, rowSequence, 0, pre.length);
                int[] post = Arrays.copyOfRange(matrix[i], columnIndex + 1, matrix[i].length);
                System.arraycopy(post, 0, rowSequence, pre.length, post.length);
            }

            minorMatrix[i - 1] = rowSequence;
        }

        return minorMatrix;
    }
}

