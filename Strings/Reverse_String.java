/*PROBLEM STATEMENT : Write a function that reverses a string. The input string is given as an array of
characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place
with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.*/

import java.io.*;

public class Reverse_String {

    static void reverseString(char[] s) {
        int left, right = 0;
        right = s.length - 1;
        for (left = 0; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            char[] s = S.toCharArray();
            reverseString(s);
            for (int i = 0; i < s.length; i++)
                System.out.print(s[i]);
        }
    }
}
