/*PROBLEM STATEMENT : Given a string 's'. The task is to find the smallest window length that contains
all the characters of the given string at least one time.
For eg. A = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca”.*/

import java.util.*;
import java.io.*;

public class Minimum_Window {

    static final int MAX_CHARS = 256;

    static int smallestWindow(String str, int n) {
        int dist_count = 0;

        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
                dist_count++;
            }
        }

        int start = 0, min_len = Integer.MAX_VALUE;

        int count = 0;
        int[] curr_count = new int[MAX_CHARS];
        for (int j = 0; j < n; j++) {
            curr_count[str.charAt(j)]++;

            if (curr_count[str.charAt(j)] == 1)
                count++;

            if (count == dist_count) {

                while (curr_count[str.charAt(start)] > 1) {
                    if (curr_count[str.charAt(start)] > 1)
                        curr_count[str.charAt(start)]--;
                    start++;
                }

                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                }
            }
        }
        return min_len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            System.out.println(smallestWindow(s, s.length()));
        }
    }
}
