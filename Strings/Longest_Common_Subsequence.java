/*PROBLEM STATEMENT : Given two sequences, find the length of longest subsequence present in both of them.
Both the strings are of uppercase.*/

import java.util.*;

public class Longest_Common_Subsequence {

    static int lcs(int p, int q, String s1, String s2) {
        int dp[][] = new int[p + 1][q + 1];

        for (int i = 0; i < p + 1; i++)
            dp[i][0] = 0;
        for (int i = 0; i < q + 1; i++)
            dp[0][i] = 0;

        for (int i = 1; i < p + 1; i++) {
            for (int j = 1; j < q + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[p][q];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(lcs(p, q, s1, s2));
        }
        sc.close();
    }
}
