/* PROBLEM STATEMENT: Given an array arr[] and a number K where K is smaller than size of array,
the task is to find the Kth smallest element in the given array. It is given that all array elements
are distinct. */
//Approach using Merge Sort :

import java.util.Scanner;

public class Kth_Smallest {

    void merge(int arr[], int beg, int mid, int end) {

        int l = mid - beg + 1;
        int r = end - mid;

        int LeftArray[] = new int[l];
        int RightArray[] = new int[r];

        for (int i = 0; i < l; ++i)
            LeftArray[i] = arr[beg + i];

        for (int j = 0; j < r; ++j)
            RightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = beg;
        while (i < l && j < r) {
            if (LeftArray[i] <= RightArray[j]) {
                arr[k] = LeftArray[i];
                i++;
            } else {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j < r) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    void merge_sort(int arr[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            merge_sort(arr, beg, mid);
            merge_sort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
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
        System.out.print("Enter Kth term for Smallest Value: ");
        int k = scan.nextInt();
        new Kth_Smallest().merge_sort(arr, 0, n - 1);
        System.out.println("Kth Smallest Value = "+ arr[k - 1]);
        scan.close();
    }

}
