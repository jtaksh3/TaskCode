/*PROBLEM STATEMENT : Given three distinct numbers A, B and C. Find the number with value in middle
(Try to do it with minimum comparisons).*/

import java.io.*;

public class Middle_of_Three {

    static int middle(int a, int b, int c) {
        int x = a - b;
        int y = b - c;
        int z = a - c;

        if (x * y > 0)
            return b;
        else if (x * z > 0)
            return c;
        else
            return a;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int A = Integer.parseInt(S[0]);
            int B = Integer.parseInt(S[1]);
            int C = Integer.parseInt(S[2]);
            System.out.println(middle(A, B, C));
        }
    }
}
