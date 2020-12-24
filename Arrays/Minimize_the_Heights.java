/*PROBLEM STATEMENT : Given an array arr[] denoting heights of N towers and a positive integer K,
you have to modify the height of each tower either by increasing or decreasing them by K only once.
After modifying, height should be a non-negative integer. Find out what could be the possible minimum
difference of the height of shortest and longest towers after you have modified each tower. */

import java.util.*;

public class Minimize_the_Heights {

    static void getMinDiff(int[] a, int n, int k) {
        Arrays.sort(a);
        int max, min, ans = a[n - 1] - a[0];

        for (int i = 1; i < n; i++) {
            if (a[i] >= k) {
                min = Math.min(a[0] + k, a[i] - k);
                max = Math.max(a[n - 1] - k, a[i - 1] + k);
                ans = Math.min(ans, max - min);
            }
        }
        System.out.println("Answer = " + ans);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        getMinDiff(arr, n, k);
    }

}
