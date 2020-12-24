//PROBLEM STATEMENT : Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order

import java.util.Scanner;

public class Sort_012 {

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = scan.nextInt();
        System.out.println("Enter elements of Array:");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int beg = 0, itr = 0, high = n - 1;
        while (itr <= high) {
            switch (arr[itr]) {
                case 0:
                    swap(arr, beg, itr);
                    beg++;
                    itr++;
                    break;
                case 1:
                    itr++;
                    break;
                case 2:
                    swap(arr, high, itr);
                    high--;
                    break;
            }
        }
        System.out.println("Sorted Array:");
        for (int i : arr)
            System.out.print(i + " ");
        scan.close();
    }

}
