/*PROBLEM STATEMENT : Count of number of given string in 2D character array*/

import java.io.*;

public class Given_String_2D_Array {

    static int match2DArray(char[][] a, int n, String b, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            String c = "", d = "", e = "", f = "";
            for (int j = 0; j < n; j++) {
                c += a[i][j];
                d = a[i][j] + d;
                e += a[j][i];
                f = a[j][i] + f;
                if (j >= m - 1) {
                    if (b.equals(c.substring(j - m + 1, j + 1)))
                        count++;
                    if (b.equals(d.substring(0, m)))
                        count++;
                    if (b.equals(e.substring(j - m + 1, j + 1)))
                        count++;
                    if (b.equals(f.substring(0, m)))
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String a[] = br.readLine().trim().split(" ");
            char[][] s = new char[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    s[i][j] = a[n * i + j].charAt(0);
            a = null;
            String b = br.readLine().trim();
            System.out.println(match2DArray(s, n, b, b.length()));
        }
    }
}
