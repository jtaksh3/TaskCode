/*PROBLEM STATEMENT : Given a row wise sorted matrix of size RxC where R and C are always odd, find the
median of the matrix.*/

import java.io.*;
import java.util.*;

class Median_in_Row_Sorted_Matrix {
    static int median(int m[][], int r, int c) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < r; i++) {
            if (m[i][0] < min)
                min = m[i][0];
            if (m[i][c - 1] > max)
                max = m[i][c - 1];
        }

        int desired = (r * c + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            for (int i = 0; i < r; ++i) {
                get = Arrays.binarySearch(m[i], mid);
                if (get < 0)
                    get = Math.abs(get) - 1;
                else {
                    while (get < m[i].length && m[i][get] == mid)
                        get += 1;
                }
                place = place + get;
            }
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int R = Integer.parseInt(input_line[0]);
            int C = Integer.parseInt(input_line[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            int ans = median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
