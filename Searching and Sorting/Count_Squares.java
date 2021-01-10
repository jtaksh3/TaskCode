/*PROBLEM STATEMENT : Consider a sample space S consisting of all perfect squares starting from 1, 4, 9
and so on. You are given a number N, you have to output the number of integers less than N in the sample
space S.*/

import java.io.*;

public class Count_Squares {

    static int countSquares(int N) {
        int r = 1, count = 0;
        for (int i = 1; i < N; i += r) {
            count++;
            r += 2;
        }
        return count;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            System.out.println(countSquares(N));
        }
    }
}
