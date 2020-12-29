/*PROBLEM STATEMENT : Given a square matrix, turn it by 90 degrees in clockwise direction without using
any extra space.*/
//BY AAKASH CHOUDHARY

import java.io.*;

public class Rotate_90_Degree {

    static void getResult(int matrix[][], int i, int n) {
        if (i >= n)
            return;
        for (int j = i; j < n - 1; j++) {
            int temp = matrix[i][i], k = i, l = i;
            while (true) {
                if (l == i && k != n - 1)
                    matrix[k][l] = matrix[++k][l];
                if (k == n - 1 && l != n - 1)
                    matrix[k][l] = matrix[k][++l];
                if (l == n - 1 && k != i)
                    matrix[k][l] = matrix[--k][l];
                if (k == i && l != i + 1)
                    matrix[k][l] = matrix[k][--l];
                if (l == i + 1 && k == i)
                    break;
            }
            matrix[i][i + 1] = temp;
        }
        getResult(matrix, i + 1, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int matrix[][] = new int[n][n];
        String[] s = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = Integer.parseInt(s[i * n + j]);
        getResult(matrix, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
