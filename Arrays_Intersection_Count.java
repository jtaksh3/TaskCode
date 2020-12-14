//PROBLEM STATEMENT : Intersection of two arrays count.

import java.util.*;

public class Arrays_Intersection_Count {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array1: ");
        int n = scan.nextInt();
        System.out.print("Enter Size of Array2: ");
        int m = scan.nextInt();
        System.out.println("Enter elements of Array1:");
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = scan.nextInt();
        System.out.println("Enter elements of Array2:");
        int arr2[] = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = scan.nextInt();
        scan.close();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int size = arr1[n - 1] > arr2[m - 1] ? arr1[n - 1] : arr2[m - 1];
        int new_arr[] = new int[size + 1], count = 0;
        ++new_arr[arr1[0]];
        int i = 1, j = 0, itr = 0;
        while (itr < (n > m ? n : m)) {
            if (i < n) {
                ++new_arr[arr1[i]];
            }
            if (j < m) {
                ++new_arr[arr2[j]];
            }
            if(i < n && new_arr[arr1[i]] > 1) {
                count++;
                new_arr[arr1[i]] = -2147483648;
            } else if(j < m && new_arr[arr2[j]] > 1) {
                count++;
                new_arr[arr2[j]] = -2147483648;
            }
            i++;
            j++;
            itr++;
        }
        System.out.println("Count of Intersection: " + count);
    }

}
