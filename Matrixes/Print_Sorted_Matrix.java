/*PROBLEM STATEMENT : The first line of input contains an integer T denoting the number of test cases.
Then T test cases follow. Each test case contains an integer n denoting the size of the matrix. Then the
next line contains the n x n elements in row wise order.*/

import java.util.*;

class Print_Sorted_Matrix {

    static final int INF = Integer.MAX_VALUE;
    static int N;

    static void youngify(int mat[][], int i, int j) {
        int downVal = (i + 1 < N) ? mat[i + 1][j] : INF;
        int rightVal = (j + 1 < N) ? mat[i][j + 1] : INF;
        if (downVal == INF && rightVal == INF)
            return;

        if (downVal < rightVal) {
            mat[i][j] = downVal;
            mat[i + 1][j] = INF;
            youngify(mat, i + 1, j);
        } else {
            mat[i][j] = rightVal;
            mat[i][j + 1] = INF;
            youngify(mat, i, j + 1);
        }
    }

    static int extractMin(int mat[][]) {
        int ret = mat[0][0];
        mat[0][0] = INF;
        youngify(mat, 0, 0);
        return ret;
    }

    static void printSorted(int mat[][]) {
        for (int i = 0; i < N * N; i++) {
            System.out.print(extractMin(mat) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            N = sc.nextInt();

            int matrix[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    matrix[i][j] = sc.nextInt();
            }
            sc.close();
            printSorted(matrix);
            System.out.println();
        }
    }
}
