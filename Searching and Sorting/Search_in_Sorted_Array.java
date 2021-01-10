/*PROBLEM STATEMENT : You are given an integer array nums sorted in ascending order (with distinct values),
and an integer target.
Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become
[4,5,6,7,0,1,2]).
If target is found in the array return its index, otherwise, return -1.*/

import java.io.*;

public class Search_in_Sorted_Array {

    static int search(int[] arr, int target) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            if (arr[l] == target)
                return l;
            else if (arr[h] == target)
                return h;
            l++;
            h--;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int target = Integer.parseInt(inputLine1[1]);
            int[] arr = new int[n];
            String[] inputLine2 = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
            System.out.println(search(arr, target));
        }
    }
}
