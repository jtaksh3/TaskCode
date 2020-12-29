/*PROBLEM STATEMENT : Java Program to Check if a string is a valid shuffle of two distinct strings*/

import java.io.*;

public class Valid_Shuffle {

    static boolean shuffleCheck(String first, String second, String result) {
        if (first.length() + second.length() != result.length()) {
            return false;
        }
        int i = 0, j = 0, k = 0;
        while (k != result.length()) {

            if (i < first.length() && first.charAt(i) == result.charAt(k))
                i++;
            else if (j < second.length() && second.charAt(j) == result.charAt(k))
                j++;
            else {
                return false;
            }
            k++;
        }
        if (i < first.length() || j < second.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();
            String[] results = br.readLine().trim().split(" ");

            for (String result : results) {
                if (shuffleCheck(s1, s2, result) == true) {
                    System.out.println(result + " is a valid shuffle of " + s1 + " and " + s2);
                } else {
                    System.out.println(result + " is not a valid shuffle of " + s1 + " and " + s2);
                }
            }
        }
    }
}
