package lab2_tema;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        solveSecondProblem();
    }

    public static void solveSecondProblem() {
        int[] array1 = {1, 7, 4, 3, 9, 1};
        int[] array2 = {6, 4, 2, 8};

        System.out.println("Array1 initial: " + Arrays.toString(array1));

        // Sortare array-uri
        bubbleSort(array1);
        System.out.println("Array1 sortat crescator: " + Arrays.toString(array1));
        System.out.println("Array2 initial: " + Arrays.toString(array2));
        bubbleSort(array2);
        System.out.println("Array2 sortat crescator: " + Arrays.toString(array2));

        // Combinare array-uri sortate
        int[] mergedArray = mergeSortedArrays(array1, array2);

        System.out.println("Output: " + Arrays.toString(mergedArray));
    }

    // Implementare Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Metoda pentru combinarea a doua tablouri sortate
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] merged = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n1) merged[k++] = arr1[i++];
        while (j < n2) merged[k++] = arr2[j++];

        return merged;
    }
}
