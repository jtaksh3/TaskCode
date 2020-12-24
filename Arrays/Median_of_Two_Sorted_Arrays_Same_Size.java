/*PROBLEM STATEMENT : There are 2 sorted arrays A and B of size n each. Write an algorithm to find the
median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity
should be O(log(n)).*/

import java.io.*;

public class Median_of_Two_Sorted_Arrays_Same_Size {

    static int median(int[] arr, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (arr[start + (n / 2)] + arr[start + (n / 2 - 1)]) / 2;
        } else {
            return arr[start + n / 2];
        }
    }

    static int getMedian(int[] a, int[] b, int startA, int startB, int endA, int endB) {
        if (endA - startA == 1) {
            return (Math.max(a[startA], b[startB]) + Math.min(a[endA], b[endB])) / 2;
        }
        int m1 = median(a, startA, endA);
        int m2 = median(b, startB, endB);

        if (m1 == m2) {
            return m1;
        } else if (m1 < m2) {
            return getMedian(a, b, (endA + startA + 1) / 2, startB, endA, (endB + startB + 1) / 2);
        } else {
            return getMedian(a, b, startA, (endB + startB + 1) / 2, (endA + startA + 1) / 2, endB);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++)
                arr1[i] = Integer.parseInt(S1[i]);
            String[] S2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++)
                arr2[i] = Integer.parseInt(S2[i]);
            System.out.println(getMedian(arr1, arr2, 0, 0, n - 1, n - 1));
        }
    }
}
