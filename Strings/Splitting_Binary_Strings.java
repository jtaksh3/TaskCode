/*PROBLEM STATEMENT : Given a binary string str of length N, the task is to find the maximum count of
substrings str can be divided into such that all the substrings are balanced i.e. they have equal number
of 0s and 1s. If it is not possible to split str satisfying the conditions then print -1.*/

import java.io.*;

public class Splitting_Binary_Strings {

    static int iterate(String str, int i, int condition) {
        int count = 1;
        while ((i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) && count < condition) {
            i++;
            count++;
        }
        return count;
    }

    static int getResult(String str) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                count1++;
            else
                count2++;
        }
        if (count1 != count2)
            return -1;

        int i = 0, counter = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '0') {
                if (count2 == 0)
                    count1 = iterate(str, i, str.length());
                else
                    count1 = iterate(str, i, count2);
                i += count1;
            } else {
                if (count1 == 0)
                    count2 = iterate(str, i, str.length());
                else
                    count2 = iterate(str, i, count1);
                i += count2;
            }
            if (count1 == count2) {
                counter++;
                count1 = count2 = 0;
            }
        }
        if (count1 != 0 || count2 != 0)
            return -1;
        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            System.out.println(getResult(s));
        }
    }
}
