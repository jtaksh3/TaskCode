/* PROBLEM STATEMENT : You are given an array that contains n integers. You are allowed to choose any
subarray and perform the following operation: Reduce an element a[i] by 1 that will cost you 1 unit
Note: You can perform this operation any number of times. Your task is to determine the longest subarray
that contains elements that are equal and ensure that the cost to make this subarray is less than k*/

import java.util.*;

public class Array_and_Cost {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        scan.close();
        int min = arr[0], count = 0, limit = 0, curr_count = 1;
        for (int i = 1; i < n; i++) {
            int a = arr[i] - min;
            limit += a;
            curr_count++;

            if (limit == k) {
                count = Math.max(count, curr_count);
                curr_count = 1;
                limit = 0;
                min = arr[i];
            } else if (limit > k || a < 0) {
                curr_count = 1;
                limit = 0;
                min = arr[i];
            }
        }
        System.out.println(count);

    }
}
