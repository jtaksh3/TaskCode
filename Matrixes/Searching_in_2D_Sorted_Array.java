/*PROBLEM STATEMENT : Given a matrix of size R*C. Traverse the matrix in spiral form.*/

import java.io.*;
import java.util.*;

class Searching_in_2D_Sorted_Array {

    static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, n = matrix.length, m = matrix[0].length;

        if (matrix[0][0] > target)
            return false;
        if (matrix[n - 1][m - 1] < target)
            return false;

        while (i + 1 < n) {
            if (matrix[i][0] == target)
                return true;
            else if (matrix[i + 1][0] > target)
                break;
            i++;
        }

        if (target > matrix[n - 1][0])
            i = n - 1;

        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[i][mid] == target)
                return true;
            else if (matrix[i][mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int target = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    matrix[i][j] = sc.nextInt();
            }
            sc.close();
            System.out.println(searchMatrix(matrix, target));
        }
    }
}
