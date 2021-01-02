/*PROBLEM STATEMENT : Given a string A and a dictionary of n words B, find out if A can be segmented into
a space-separated sequence of dictionary words. */

import java.util.*;

public class Word_Break {

    public static int wordBreak(String A, ArrayList<String> B) {
        // code here
        int dp[] = new int[A.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String w2check = A.substring(j, i + 1);
                if (B.contains(w2check)) {
                    if (j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] += 1;
                }
            }
        }
        if (dp[dp.length - 1] == 0)
            return 0;
        return 1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            ArrayList<String> arr = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String p = sc.next();
                arr.add(p);
            }
            String line = sc.next();
            System.out.println(wordBreak(line, arr));
        }
        sc.close();
    }
}
