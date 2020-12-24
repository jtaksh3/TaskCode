/* PROBLEM STATEMENT : Given an array of intervals where intervals[i] = [starti, endi], merge all
overlapping intervals, and return an array of the non-overlapping intervals that cover all the
intervals in the input.*/

import java.util.*;

public class Merge_Intervals {

    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int i = 0, j = 0;
        while(i < n && j < n) {
            int k = j + 1, min = intervals[j][0], max = intervals[j][1];
            while(k < n) {
                if(max >= intervals[k][0]) {
                    max = Math.max(max, intervals[k][1]);
                }
                else {
                    break;
                }
                k++;
            }
            intervals[i][0] = min;
            intervals[i][1] = max;
            i++;
            j = k;
        }
        int ans[][] = new int[i][2];
        for(int k = 0; k < i; k++) {
            ans[k][0] = intervals[k][0];
            ans[k][1] = intervals[k][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number of Intervals: ");
        int n = scan.nextInt();
        System.out.println("Enter Intervals:");
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        scan.close();
        arr = merge(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][0] + " " + arr[i][1] + " ");
        }
    }
}
