/*PROBLEM STATEMENT : Given an array A[] of N numbers and another number x, determine whether or not
there exist three elements in A[] whose sum is exactly x.*/

import java.util.*;

public class Tripplet_Sum {
    static int find3Numbers(int A[], int n, int x) {
        int l, r;

        for (int i = 0; i < n - 2; i++) {
            l = i + 1;
            r = n - 1;
            while (l < r) {
                if (A[i] + A[l] + A[r] == x) {
                    return 1;
                } else if (A[i] + A[l] + A[r] < x)
                    l++;
                else
                    r--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int x = scan.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();
            scan.close();
            Arrays.sort(arr);
            System.out.println(find3Numbers(arr, n, x));
        }
    }
}
