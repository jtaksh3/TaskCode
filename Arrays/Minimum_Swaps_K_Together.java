/*PROBLEM STATEMENT : Given an array of n positive integers and a number k. Find the minimum number of
swaps required to bring all the numbers less than or equal to k together.*/

import java.io.*;

public class Minimum_Swaps_K_Together {
    static int minimum_swaps(int arr[], int n, int k) {
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;

        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++bad;

        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {
            if (arr[i] > k)
                --bad;

            if (arr[j] > k)
                ++bad;

            ans = Math.min(ans, bad);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine2[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(inputLine2[i]);
            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(minimum_swaps(arr, n, k));
        }
    }
}
