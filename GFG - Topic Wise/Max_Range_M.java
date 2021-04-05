/*Problem Statement - 
Given an array of size N with all initial values as 0, write a program to perform following M range
increment operations as shown below: 
increment(a, b, k) : Increment values from 'a'
                     to 'b' by 'k'.  
After M operations, calculate the maximum value in the array.

First line of input contains a single integer T which denotes the number of test cases. T test cases
follows. First line of each test case contains two space separated integers N and M. Next M lines of
each test case contains three space separated integers a , b and k.
*/

import java.io.*;

public class Max_Range_M {

    static void increment(int arr[], int i, int n, int inc) {
        arr[i] += inc;
        arr[n + 1] -= inc;
    }

    static long findMaximum(int arr[], int n) {
        long sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            int arr[] = new int[n + 1];
            String s2[] = br.readLine().trim().split(" ");
            int i = 0;
            while (m-- > 0) {
                increment(arr, Integer.parseInt(s2[i]), Integer.parseInt(s2[i + 1]), Integer.parseInt(s2[i + 2]));
                i += 3;
            }
            System.out.println(findMaximum(arr, n));
        }
    }
}
