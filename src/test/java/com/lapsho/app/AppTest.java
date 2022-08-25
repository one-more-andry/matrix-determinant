package com.lapsho.app;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void determinant_NullInput_ThrowsException() {
        IllegalArgumentException output = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {App.determinant(null);},
                "null instead of array exception expected: ");

        assertEquals(App.NULL_INSTEAD_MATRIX_EXCEPTION_MESSAGE, output.getMessage());
    }

    @Test
    public void determinant_NullInputOnFirstLevel_ThrowsException() {
        int[][] input = {{1, 2}, null};
        IllegalArgumentException output = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {App.determinant(input);},
                "null instead of matrix row exception expected: ");

        assertEquals(App.NULL_INSTEAD_MATRIX_ROW_EXCEPTION_MESSAGE, output.getMessage());
    }

    @Test
    public void determinant_Invalid2x3Proportion_ThrowsException()
    {
        int[][] input = {{1, 2, 3}, {7, 10, 9}};
        IllegalArgumentException output = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {App.determinant(input);},
                "Invalid matrix proportion exception expected: ");

        assertTrue(output.getMessage().contains(App.INVALID_MATRIX_PROPORTION_EXCEPTION_MESSAGE));
    }

    @Test
    public void determinant_Invalid3x2Proportion_ThrowsException()
    {
        int[][] input = {{1, 2}, {4, 5}, {7, 10}};
        IllegalArgumentException output = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {App.determinant(input);},
                "Invalid matrix proportion exception expected: ");

        assertTrue(output.getMessage().contains(App.INVALID_MATRIX_PROPORTION_EXCEPTION_MESSAGE));
    }

    @Test
    public void determinant_N4NegativeAndZeroAndNaturalNumbers_ShouldPass() {
        int[][] input = {{1, 0, 2, -1},
                {3, 0, 0, 5},
                {2, 1, 4, -3},
                {1, 0, 5, 0}};
        int expectedOutput = 30;
        int output = App.determinant(input);

        assertEquals("Invalid determinant calculation: ", expectedOutput, output);
    }

    @Test
    public void determinant_N3NaturalNumbers_ShouldPass()
    {
        int[][] input = {{1, 2, 3},
                {4, 5, 6},
                {7, 10, 9}};
        int expectedOutput = 12;
        int output = App.determinant(input);

        assertEquals("Invalid determinant calculation: ", expectedOutput, output);
    }
}
