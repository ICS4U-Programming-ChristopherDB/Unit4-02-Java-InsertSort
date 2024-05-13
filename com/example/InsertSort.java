package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Change me.
 *
 * @author Christopher Di Bert
 * @version 1.0
 * @since 2024-05-13
 */

// InsertSort class
public final class InsertSort {

  /** Private constructor to prevent instantiation. */
  private InsertSort() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    File readFile = new File("input.txt");
    try {
      FileWriter fileWriter = new FileWriter("output.txt");
      BufferedWriter writer = new BufferedWriter(fileWriter);
      Scanner sc = new Scanner(readFile);
      while (sc.hasNextLine()) {
        // Gets input lines.
        String inputElements = sc.nextLine();
        try {
          // Sets line to an array delimited by spaces.
          String[] lineArr = inputElements.split(" ");
          // Casts from string to int stream.
          IntStream ints = Arrays.stream(lineArr).mapToInt(Integer::parseInt);
          // Converts int stream to int array.
          int[] intArr = ints.toArray();
          // Writes the sorted array to the output file.
          writer.write(Arrays.toString(InsertionSort(intArr)));
          // Exception thrown if the user didn't enter valid input.
        } catch (Exception e) {
          writer.write("Can only enter space-separated integers!");
        }
        writer.newLine();
      }
      writer.close();
      sc.close();
    } catch (Exception e) {
      System.out.println("Invalid path");
    }
  }

  /**
   * Insertion sort
   *
   * @param arr
   * @return sorted array.
   */
  private static int[] InsertionSort(int[] arr) {
    // Initializes temp.
    int temp = 0;
    // Iterates over every element of array.
    for (int i = 1; i < arr.length; i++) {
      int j = i;
      // Checks if current element is smaller than previous, if so, swap.
      while (j > 0 && arr[j] < arr[j - 1]) {
        temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
        j--;
      }
    }
    // Returns the sorted array.
    return arr;
  }
}
