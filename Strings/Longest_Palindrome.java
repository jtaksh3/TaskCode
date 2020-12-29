/*PROBLEM STATEMENT : Given a string S, find the longest palindromic substring in S. Substring of string S:
S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More
formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first
( with the least starting index ).*/
//BY AAKASH CHOUDHARY

import java.io.*;

public class Longest_Palindrome {

    static int palindromeCount(char[] s, int i, int n) {
        int low = i, high = n;
        while (low < high) {
            if (s[low++] != s[high--])
                return 0;
        }
        return n - i;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            char[] s = S.toCharArray();
            int count = 0, index1 = 0;
            for (int i = 0; i < s.length; i++) {
                int n = s.length - 1;
                while (n > i) {
                    int counter = palindromeCount(s, i, n);
                    if (counter > count) {
                        count = counter;
                        index1 = i;
                    }
                    n--;
                    if (counter != 0)
                        break;
                }
            }
            for (int i = index1; i <= index1 + count; i++)
                System.out.print(s[i]);
            System.out.println();
        }
    }
}
