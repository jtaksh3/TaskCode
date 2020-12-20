/*PROBLEM STATEMENT : Given an array of integers (A[])  and a number x, find the smallest subarray with
sum greater than the given value.*/

import java.io.*;

public class Smallest_SubArray {
    static int subarray_count(int arr[], int n, int x) {
        int curr_sum = 0, min_len = n + 1;
        int start = 0, end = 0;
        while (end < n) {
            while (curr_sum <= x && end < n)
                curr_sum += arr[end++];
            while (curr_sum > x && start < n) {
                min_len = Math.min(min_len, (end - start));
                curr_sum -= arr[start++];
            }
        }
        return min_len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int x = Integer.parseInt(inputLine1[1]);
            int arr[] = new int[n];
            String inputLine2[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(inputLine2[i]);
            System.out.println(subarray_count(arr, n, x));
        }
    }
}
