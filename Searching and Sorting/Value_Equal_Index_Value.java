/*PROBLEM STATEMENT : Given an array Arr of N positive integers. Your task is to find the elements whose
value is equal to that of its index value.*/

import java.util.*;
import java.io.*;

public class Value_Equal_Index_Value {

    static ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            if (i + 1 == arr[i])
                al.add(arr[i]);

        return al;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = valueEqualToIndex(arr, n);
            if (ans.size() == 0) {
                System.out.println("Not Found");
            } else {
                for (Integer x : ans) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
