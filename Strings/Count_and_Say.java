/*PROBLEM STATEMENT : The count-and-say sequence is a sequence of digit strings defined by the recursive
formula:
countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted
into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is
a contiguous section all of the same character. Then for each group, say the number of characters, then say
the character. To convert the saying into a digit string, replace the counts with a number and concatenate
every saying.*/

import java.io.*;

public class Count_and_Say {

    static int count(char[] s, int i) {
        int count = 1;
        while (i + 1 < s.length && s[i] == s[i + 1]) {
            count++;
            i++;
        }
        return count;
    }

    static String say(String S) {
        char[] s = S.toCharArray();
        S = "";
        int i = 0;
        while (i < s.length) {
            int count = count(s, i);
            S = S + count + s[i];
            i += count;
        }
        return S;
    }

    static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = say(result);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(countAndSay(n));
        }
    }
}
