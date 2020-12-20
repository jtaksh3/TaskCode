/*PROBLEM STATEMENT : Given an array of positive integers. Find the length of the longest sub-sequence such
that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.*/

import java.util.*;

public class Consecutive_Numbers {

    static int findLongestConseqSubseq(int arr[], int N) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            hs.add(arr[i]);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(!hs.contains(arr[i] - 1)) {
                int j = arr[i];
                while(hs.contains(j))
                    j++;
                if (ans < j - arr[i]) 
                    ans = j - arr[i]; 
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        sc.close();

        System.out.println(findLongestConseqSubseq(a, n));
    }
}
