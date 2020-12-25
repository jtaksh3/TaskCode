/*PROBLEM STATEMENT : Given a matrix of size R*C. Traverse the matrix in spiral form.*/

import java.io.*;
import java.util.*;

class Spiral_Traverse {

    static void print(int arr[][], int i, int j, int m, int n, ArrayList<Integer> al) {
        if (i >= m || j >= n)
            return;

        for (int p = i; p < n; p++)
            al.add(arr[i][p]);

        for (int p = i + 1; p < m; p++)
            al.add(arr[p][n - 1]);

        if ((m - 1) != i)
            for (int p = n - 2; p >= j; p--)
                al.add(arr[m - 1][p]);

        if ((n - 1) != j)
            for (int p = m - 2; p > i; p--)
                al.add(arr[p][j]);

        print(arr, i + 1, j + 1, m - 1, n - 1, al);
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        print(matrix, 0, 0, r, c, al);
        return al;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    matrix[i][j] = sc.nextInt();
            }
            sc.close();
            ArrayList<Integer> ans = spirallyTraverse(matrix, r, c);
            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
