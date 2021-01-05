/*PROBLEM STATEMENT : You are given a string of 2N characters consisting of N ‘[‘ brackets and N ‘]’
brackets. A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2
are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters.
Calculate the minimum number of swaps necessary to make a string balanced.*/

import java.util.*;
import java.io.*;

public class Minimum_Swaps_Bracket_Balancing {

    static int swapsCount(char[] s, int n) {
        Stack<Character> st = new Stack<Character>();
        int i = 0, count = 0;
        while (i < n) {
            if (s[i] == '[') {
                st.push('[');
                i++;
            } else {
                if (!st.empty()) {
                    st.pop();
                    i++;
                } else {
                    char temp = s[i];
                    int j = i + 1;
                    while (j < n && s[j] != '[')
                        j++;
                    s[i] = s[j];
                    s[j] = temp;
                    count += j - i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            System.out.println(swapsCount(s.toCharArray(), n));
        }
    }
}
