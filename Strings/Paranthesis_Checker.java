/*PROBLEM STATEMENT : Given an expression string x. Examine whether the pairs and the orders of
“{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.*/

import java.util.*;

public class Paranthesis_Checker {

    static int checkSymbol(char a) {
        if (a == '{')
            return 1;
        if (a == '}')
            return -1;
        if (a == '[')
            return 2;
        if (a == ']')
            return -2;
        if (a == '(')
            return 3;
        if (a == ')')
            return -3;
        return 0;
    }

    static boolean ispar(String x) {
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < x.length(); i++) {
            int a = checkSymbol(x.charAt(i));
            if (a > 0) {
                s.push(a);
            } else {
                if (!s.empty() && s.peek() == Math.abs(a))
                    s.pop();
                else
                    return false;
            }
        }
        if (!s.empty())
            return false;
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String st = sc.next();
            if (ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }
        sc.close();
    }
}
