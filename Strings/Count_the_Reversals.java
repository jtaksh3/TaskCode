/*PROBLEM STATEMENT : Given a string S consisting only of opening and closing curly brackets '{' and '}'
find out the minimum number of reversals required to make a balanced expression.*/

import java.util.*;

public class Count_the_Reversals {

    static int countReversals(String str, int n) {
        if (n % 2 == 1)
            return -1;

        Stack<Character> st = new Stack<Character>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '{')
                st.push('{');
            else {
                if (!st.empty() && st.peek() == '{')
                    st.pop();
                else {
                    count++;
                    st.push('{');
                }
            }
        }
        return st.size() / 2 + count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            String s = scan.next();
            System.out.println(countReversals(s, s.length()));
        }
        scan.close();
    }
}
