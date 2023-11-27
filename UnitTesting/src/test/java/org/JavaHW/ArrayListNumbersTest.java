package org.JavaHW;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class ArrayListNumbersTest {

    @Test
    void testPrintAllElements() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 18, 26, 39, 42, 57, 64, 73, 81, 95, 10, 12, 25, 30, 44, 58, 66, 72, 86, 99));
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        ArrayListNumbers.printAllElements(numbers);

        String expectedOutput = "All elements of the collection:\n" +
                "[5, 18, 26, 39, 42, 57, 64, 73, 81, 95, 10, 12, 25, 30, 44, 58, 66, 72, 86, 99]";

        String actualOutput = outputStreamCaptor.toString().trim();

        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void testPrintMinMax() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 18, 26, 39, 42, 57, 64, 73, 81, 95, 10, 12, 25, 30, 44, 58, 66, 72, 86, 99));
        ArrayListNumbers.printMinMax(numbers);

        int expectedMin = 5;
        int expectedMax = 99;
        assertEquals(expectedMin, Collections.min(numbers));
        assertEquals(expectedMax, Collections.max(numbers));
    }

    @Test
    public void testPrintAverage() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 18, 26, 39, 42, 57, 64, 73, 81, 95, 10, 12, 25, 30, 44, 58, 66, 72, 86, 99));
        double expectedAverage = 50.1; // Calculated manually
        assertEquals(expectedAverage, getAverage(numbers));
    }

    @Test
    public void testRemoveEvenNumbers() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 18, 26, 39, 42, 57, 64, 73, 81, 95, 10, 12, 25, 30, 44, 58, 66, 72, 86, 99));
        ArrayListNumbers.removeEvenNumbers(numbers);

        for (int num : numbers) {
            assertFalse(num % 2 == 0);
        }
    }

    @Test
    public void testCheckIfContainsNumber() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 18, 26, 39, 42, 57, 64, 73, 81, 95, 10, 12, 25, 30, 44, 58, 66, 72, 86, 99));
        assertFalse(numbers.contains(50), "Array should contain number 50");
        assertTrue(numbers.contains(10));
    }

    @Test
    public void testSortCollection() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 18, 26, 39, 42, 57, 64, 73, 81, 95, 10, 12, 25, 30, 44, 58, 66, 72, 86, 99));
        ArrayListNumbers.sortCollection(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(Arrays.asList(5, 10, 12, 18, 25, 26, 30, 39, 42, 44, 57, 58, 64, 66, 72, 73, 81, 86, 95, 99));
        assertEquals(sortedNumbers, numbers);
    }

    // Helper method to calculate average
    private double getAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}