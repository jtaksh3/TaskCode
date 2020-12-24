/*PROBLEM STATEMENT : Given an array arr[] of N integers, calculate the median*/

import java.util.*;
import java.io.*;

public class Median_of_Sorted_Array {

    static int find_median(int[] v) {
        int n = v.length;
        Arrays.sort(v);
        if (n % 2 == 1)
            return v[n / 2];
        else
            return (v[n / 2] + v[(n / 2) - 1]) / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[n];
            for (int i = 0; i < n; i++)
                v[i] = Integer.parseInt(S[i]);
            int ans = find_median(v);
            System.out.println(ans);
        }
    }
}
