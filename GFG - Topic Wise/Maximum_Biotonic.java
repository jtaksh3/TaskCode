/*PROBLEM STATEMENT : Given an array of integers A. A subsequence of A is called Bitonic if it is first
increasing then decreasing.
The first line contains an integer T denoting the no of test cases. Each test case consist of two lines.
The first line contains an integer N denoting the size of the array. Then in the next line are N space
separated values of the array A[].*/

import java.io.*;

public class Maximum_Biotonic {

    public static int bitonic(int arr[], int n) {
        int max = Integer.MIN_VALUE;

        int msbi[] = new int[n];
        int msbd[] = new int[n];

        for (int i = 0; i < n; i++) {
            msbi[i] = arr[i];
            msbd[i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msbi[i] < msbi[j] + arr[i])
                    msbi[i] = msbi[j] + arr[i];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && msbd[i] < msbd[j] + arr[i])
                    msbd[i] = msbd[j] + arr[i];
            }
        }

        for (int i = 0; i < n; i++)
            max = Math.max(max, (msbd[i] + msbi[i] - arr[i]));

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            System.out.println(bitonic(arr, n));
        }
    }
}
