/*PROBLEM STATEMENT : Given an array and a positive integer k, find the first negative integer for each
and every window(contiguous subarray) of size k.
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
Each test case contains an integer n denoting the size of the array. The next line contains n space separated
integers forming the array. The last line contains the window size k.*/

import java.util.*;
import java.io.*;

public class Negative_in_SubArray {
    public static void negativeWindow(int arr[], int n, int k) {
        LinkedList<Integer> dequeue = new LinkedList<>();
        for (int i = 0; i < k; i++)
            if (arr[i] < 0)
                dequeue.add(i);

        for (int i = k; i < n; i++) {
            if (!dequeue.isEmpty())
                System.out.print(arr[dequeue.peek()] + " ");
            else
                System.out.print("0 ");

            while ((!dequeue.isEmpty()) && dequeue.peek() < (i - k + 1))
                dequeue.remove();

            if (arr[i] < 0)
                dequeue.add(i);
        }

        if (!dequeue.isEmpty())
            System.out.print(arr[dequeue.peek()] + " ");
        else
            System.out.print("0" + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s[] = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            negativeWindow(arr, n, k);
            System.out.println();
        }
    }
}
