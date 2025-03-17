    package lab2_tema;

//1. Implementati o aplicatie Java in care:
//        a) cititi de la tastatura un numar intreg n cuprins intre [0, 5].
//        Nota: interactiunea cu userul va continua atat timp cat acesta nu a furnizat o valoare valida.
//        b) creati un tablou unidimensional de lungime n, ale carui elemente intregi le cititi de la tastatura.
//        c) implementati o metoda care realizeaza inversarea ordinii initiale a elementelor tabloului si afisarea lui in consola.
//        exemplu: Input: [2, 4, 1, 5, 3]
//        Output: [3, 5, 1, 4, 2]

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        solveFirstProblem();
    }
    public static void solveFirstProblem() {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Citire nr valid [0,5]
        do {
            System.out.print("Introduceti un numar intre 0 si 5: ");
            n = scanner.nextInt();
        } while (n < 0 || n > 5);

        int[] array = new int[n];

        // Citire elemente tablou
        System.out.println("Introduceti " + n + " elemente:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Inversare tablou
        reverseArray(array);

        // Afisare tablou inversat
        System.out.println("Tabloul inversat este: " + Arrays.toString(array));
    }

    // Metoda pentru inversarea unui tablou
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
