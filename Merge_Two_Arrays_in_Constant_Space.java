/*PROBLEM STATEMENT: Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array
is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing
order without using any extra space.*/

import java.util.Scanner;

public class Merge_Two_Arrays_in_Constant_Space {

    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    static void merge(int arr1[], int arr2[], int n, int m) {
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (i = 0; i + gap < n; i++) {
               if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }
            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array1: ");
        int n = scan.nextInt();
        System.out.print("Enter Size of Array2: ");
        int m = scan.nextInt();
        System.out.println("Enter elements of Array1:");
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = scan.nextInt();
        System.out.println("Enter elements of Array2:");
        int arr2[] = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = scan.nextInt();
        scan.close();
        merge(arr1, arr2, n, m);
        System.out.println("Merged Array:");
        for (int i : arr1)
            System.out.print(i + " ");
        for (int i : arr2)
            System.out.print(i + " ");
    }

}
