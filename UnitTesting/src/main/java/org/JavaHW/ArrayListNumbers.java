package org.JavaHW;
import java.util.*;

public class ArrayListNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 18, 26, 39, 42, 57, 64, 73, 81, 95, 10, 12, 25, 30, 44, 58, 66, 72, 86, 99));
        // I assigned a set of numbers instead of doing random because I didn't manage to create tests with the randomized method

        printAllElements(numbers);
        printMinMax(numbers);
        printAverage(numbers);
        removeEvenNumbers(numbers);
        checkIfContainsNumber(numbers, 50);
        sortCollection(numbers);
    }

    // Method to print all elements of the collection
    public static void printAllElements(List<Integer> numbers) {
        System.out.println("All elements of the collection:");
        System.out.println(numbers);
    }

    // Method to print minimum and maximum numbers
    public static void printMinMax(List<Integer> numbers) {
        int minNumber = Collections.min(numbers);
        int maxNumber = Collections.max(numbers);
        System.out.println("\nMinimum number: " + minNumber);
        System.out.println("Maximum number: " + maxNumber);
    }

    // Method to print average value
    public static void printAverage(List<Integer> numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = sum / numbers.size();
        System.out.println("\nAverage value is: " + average);
    }

    // Method to remove even numbers
    public static void removeEvenNumbers(List<Integer> numbers) {
        for (int j = 0; j < numbers.size(); j++) {
            int num = numbers.get(j);
            if (num % 2 == 0) {
                numbers.remove(j);
                j--;
            }
        }
        System.out.println("\nCollection without even numbers:");
        System.out.println(numbers);
    }

    // Method to check if a given number exists in the collection
    public static void checkIfContainsNumber(List<Integer> numbers, int givenNumber) {
        boolean containsNumber = numbers.contains(givenNumber);
        System.out.println("\nDoes the collection contain " + givenNumber + "? " + containsNumber);
    }


    // Method to sort the collection
    public static void sortCollection(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println("\nSorted collection: ");
        System.out.println(numbers);
    }
}
