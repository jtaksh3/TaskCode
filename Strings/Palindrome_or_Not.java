/*PROBLEM STATEMENT : Given a string S, check if it is palindrome or not.*/

import java.io.*;

public class Palindrome_or_Not {

    static int isPlaindrome(String S) {
        char a[] = S.toCharArray();
        int i = 0, n = a.length;
        while (i < n) {
            if (a[i++] != a[--n])
                return 0;
        }
        return 1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            System.out.println(isPlaindrome(S));
        }
    }
}
