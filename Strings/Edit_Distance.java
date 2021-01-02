/*PROBLEM STATEMENT : Given two strings s and t. Find the minimum number of operations that need to be
performed on str1 to convert it to str2. The possible operations are:
Insert
Remove
Replace
*/

import java.io.*;

class Edit_Distance {

    static int editDistance(String s, String t) {
        int[][] dp = new int[t.length()][s.length()];
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    if (i == 0 && j == 0)
                        dp[i][j] = 0;
                    else if (i == 0)
                        dp[i][j] = j;
                    else if (j == 0)
                        dp[i][j] = i;
                    else
                        dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (i == 0 && j == 0)
                        dp[i][j] = 1;
                    else if (i == 0)
                        dp[i][j] = dp[i][j - 1] + 1;
                    else if (j == 0)
                        dp[i][j] = dp[i - 1][j] + 1;
                    else
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[t.length() - 1][s.length() - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            int ans = editDistance(s, t);
            System.out.println(ans);
        }
    }
}
