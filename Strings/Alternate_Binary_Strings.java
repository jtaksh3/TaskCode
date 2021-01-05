/*PROBLEM STATEMENT: Given a binary string, that is it contains only 0s and 1s. We need to make this
string a sequence of alternate characters by flipping some of the bits, our goal is to minimize the
number of bits to be flipped.*/

import java.io.*;

public class Alternate_Binary_Strings {

    static int flipsCount(String s, int n) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && s.charAt(i) != '0')
                count1++;
            if (i % 2 == 1 && s.charAt(i) != '1')
                count1++;
            if (i % 2 == 1 && s.charAt(i) != '0')
                count2++;
            if (i % 2 == 0 && s.charAt(i) != '1')
                count2++;
        }
        return Math.min(count1, count2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            System.out.println(flipsCount(s, s.length()));
        }
    }
}
