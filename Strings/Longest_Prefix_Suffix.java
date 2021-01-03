/*PROBLEM STATEMENT : Given a string of characters, find the length of the longest proper prefix which
is also a proper suffix.*/

import java.io.*;

class Longest_Prefix_Suffix {

    static int lps(String s) {
        int n = s.length();
        String a = "", b = "";
        for (int i = 0; i < n - 1; i++) {
            a = s.substring(0, n - i - 1);
            b = s.substring(i + 1, n);
            if (a.equals(b))
                return (n - i - 1);
        }
        return 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            System.out.println(lps(s));
        }
    }
}
