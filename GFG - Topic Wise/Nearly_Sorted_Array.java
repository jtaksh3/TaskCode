/*PROBLEM STATEMENT : Given an array of n elements, where each element is at most k away from its target
position. The task is to print array in sorted form. 
First line consists of T test cases. First line of every test case consists of two integers N and K,
denoting number of elements in array and at most k positions away from its target position respectively.
Second line of every test case consists of elements of array.*/

import java.util.*;
import java.io.*;

public class Nearly_Sorted_Array {

    static void sortArray(int arr[], int n, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k; i++)
            priorityQueue.add(arr[i]);

        int index = 0;
        for (int i = k; i < n; i++) {
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int k = Integer.parseInt(s1[1]);
            String s2[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s2[i]);
            sortArray(arr, n, k);
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}
