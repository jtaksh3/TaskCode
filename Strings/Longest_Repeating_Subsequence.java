/*Given a string str, find length of the longest repeating subseequence such that the two subsequence don’t
have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have
the same index in the original string.*/

import java.io.*;

public class Longest_Repeating_Subsequence {

    static int findLongestRepeatingSubSeq(String str, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j) && i != j)
                    dp[i][j] = 1 + dp[i + 1][j + 1];

                else
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String S = br.readLine().trim();
            System.out.println(findLongestRepeatingSubSeq(S, n));
        }
    }
}
