/*PROBLEM STATEMENT : Given an array of positive and negative numbers, arrange them in an alternate
fashion such that every positive number is followed by negative and vice-versa maintaining the order
of appearance.
Number of positive and negative numbers need not be equal. If there are more positive numbers they appear
at the end of the array. If there are more negative numbers, they too appear in the end of the array.
*/

import java.util.Scanner;

public class Rearrange_Array_Positive_Negative {

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void rearrange(int arr[], int n) {
        char a;
        int itr = 0, end = arr.length - 1;
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
        if(itr % 2 == 1) {
            itr++;
        }
        for(int i = 1; i < n && itr < n; i += 2) {
            if(arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[itr];
                arr[itr] = temp;
                itr += 2;
            }
        }
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
        rearrange(arr, n);
        for(int i : arr)
            System.out.print(i + " ");
    }

}