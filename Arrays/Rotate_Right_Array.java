//PROBLEM STATEMENT : Cyclically rotate an array by one

import java.util.Scanner;

public class Rotate_Right_Array {

    static void rotate_array(int arr[], int n) {
        int initial = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = initial;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = scan.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements of Array:");
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        scan.close();
        rotate_array(arr, n);
        System.out.println("Resultant Array:");
        for (int i : arr)
            System.out.print(i + " ");
    }

}
