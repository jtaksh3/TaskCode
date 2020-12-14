//PROBLEM STATEMENT : Move all negative numbers to beginning and positive to end with constant extra space

import java.util.Scanner;

public class Negative_Elements_at_left {

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
        scan.close();
        char a;
        int itr = 0, end = n - 1;
        while (itr < end) {
            if (arr[itr] < 0) {
                a = 'n';
            } else {
                a = 'p';
            }
            switch (a) {
                case 'n':
                    itr++;
                    break;
                case 'p':
                    swap(arr, itr, end);
                    end--;
                    break;
            }
        }
        System.out.println("Resultant Array:");
        for (int i : arr)
            System.out.print(i + " ");
    }

}
