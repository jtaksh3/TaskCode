/*PROBLEM STATEMENT : Given a sorted array with possibly duplicate elements, the task is to find indexes
of first and last occurrences of an element x in the given array.
Note: If the number x is not found in the array just print '-1'.*/

import java.io.*;

public class First_Last_Occurence_Index {

    static void first_last_occurence(int arr[], int n, int k) {
        int l = 0, h = n - 1, index1 = -1, index2 = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == k) {
                l = h = mid;
                while (l >= 0 && arr[mid] == arr[l])
                    l--;
                while (h < n && arr[mid] == arr[h])
                    h++;
                index1 = l + 1;
                index2 = h - 1;
                break;
            } else if (arr[mid] > k) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        if (index1 == -1)
            System.out.println("-1");
        else
            System.out.println(index1 + " " + index2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String S2[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(S2[i]);
            first_last_occurence(arr, n, k);
        }
    }
}
