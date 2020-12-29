/*PROBLEM STATEMENT : Given an n x n matrix mat[n][n] of integers, find the maximum value of
mat(c, d) – mat(a, b) over all choices of indexes such that both c > a and d > b*/

import java.io.*;

public class Specific_Pair_in_Matrix {

    static int specific_max(int matrix[][], int r, int c) {
        int maxValue = Integer.MIN_VALUE;
        int maxArr[][] = new int[r][c];

        maxArr[r - 1][c - 1] = matrix[r - 1][c - 1];

        int maxv = matrix[r - 1][c - 1];
        for (int j = c - 2; j >= 0; j--) {
            if (matrix[r - 1][j] > maxv)
                maxv = matrix[r - 1][j];
            maxArr[r - 1][j] = maxv;
        }
        maxv = matrix[r - 1][c - 1];
        for (int i = r - 2; i >= 0; i--) {
            if (matrix[i][c - 1] > maxv)
                maxv = matrix[i][c - 1];
            maxArr[i][c - 1] = maxv;
        }
        for (int i = r - 2; i >= 0; i--) {
            for (int j = c - 2; j >= 0; j--) {
                if (maxArr[i + 1][j + 1] - matrix[i][j] > maxValue)
                    maxValue = maxArr[i + 1][j + 1] - matrix[i][j];

                maxArr[i][j] = Math.max(matrix[i][j], Math.max(maxArr[i][j + 1], maxArr[i + 1][j]));
            }
        }

        return maxValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int r = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());
            int matrix[][] = new int[r][c];
            String[] s = br.readLine().trim().split(" ");
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    matrix[i][j] = Integer.parseInt(s[i * c + j]);
            System.out.println(specific_max(matrix, r, c));
        }
    }

}
