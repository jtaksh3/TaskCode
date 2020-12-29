/*PROBLEM STATEMENT : Given a boolean 2D array of n x m dimensions where each row is sorted. Find the
0-based index of the first row that has the maximum number of 1's.*/

import java.io.*;

public class Row_with_Max_1s {

    static int rowWithMax1s(int arr[][], int n, int m) {
        int counter = 0, index = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = m - 1; j > -1; j--) {
                if (arr[i][j] == 0)
                    break;
                count++;
            }
            if (count > counter) {
                counter = count;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
