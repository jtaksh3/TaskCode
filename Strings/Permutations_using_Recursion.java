/*PROBLEM STATEMENT : Given a string S. The task is to print all permutations of a given string.*/

import java.util.*;
import java.io.*;

public class Permutations_using_Recursion {

    static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String lp = str.substring(0, i);
            String rp = str.substring(i + 1);
            String res = lp + rp;
            permute(res, ans + ch);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            char tempArray[] = S.toCharArray();
            Arrays.sort(tempArray);
            permute(new String(tempArray), "");
            System.out.println();
        }
    }
}
