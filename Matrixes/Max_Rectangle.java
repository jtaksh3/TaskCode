/*PROBLEM STATEMENT : Given a binary matrix. Find the maximum area of a rectangle formed only of 1s in
the given matrix.*/

import java.util.*;

class Max_Rectangle {

    static int maxHist(int R, int C, int row[]) {
        Stack<Integer> result = new Stack<Integer>();

        int top_val, max_area = 0, area = 0, i = 0;
        while (i < C) {
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++);

            else {
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }
        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }

    static int maxArea(int A[][], int R, int C) {
        int result = maxHist(R, C, A[0]);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++)
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];

            result = Math.max(result, maxHist(R, C, A[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[1000][1000];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();
            sc.close();
            System.out.println(maxArea(a, m, n));
        }
    }
}
