/* PROBLEM STATEMENT - Given an unsorted array arr[] of size N, rotate it by D elements (clockwise).
The first line of the input contains T denoting the number of testcases. First line of each test case
contains two space separated elements, N denoting the size of the array and an integer D denoting the
number size of the rotation. Subsequent line will be the N space separated array elements.
*/

import java.io.*;

public class Rotation {
    static void rotateArray(int arr[], int n, int d) {
        System.out.print(arr[d]);
        for (int i = d + 1; i < n; i++)
            System.out.print(" " + arr[i]);
        for (int i = 0; i < d; i++)
            System.out.print(" " + arr[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int d = Integer.parseInt(s1[1]);
            String s2[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s2[i]);
            rotateArray(arr, n, d);
            System.out.println();
        }
    }
}
