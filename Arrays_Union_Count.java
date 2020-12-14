//PROBLEM STATEMENT : Union of two arrays count.

import java.util.*;

public class Arrays_Union_Count {

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
        for(int i = 0; i < n; i++) {
            if (new_arr[arr1[i]] == 0) {
                ++new_arr[arr1[i]];
                count++;
            }
        }
        for(int j = 0; j < m; j++) {
            if (new_arr[arr2[j]] == 0) {
                ++new_arr[arr2[j]];
                count++;
            }
        }
        System.out.println("Count of Union: " + count);
    }

}
