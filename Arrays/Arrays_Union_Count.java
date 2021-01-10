//PROBLEM STATEMENT : Union of two arrays count.

import java.util.*;

class Array_Union_Count {

    static int return_union_count(int[] arr1, int arr2[], int n, int m) {
        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            // Increment the i'th counter till the next value in arr1 is different
            while (i + 1 < n && arr1[i] == arr1[i + 1]) {
                i++;
            }
            // Increment the j'th counter till the next value in arr2 is different
            while (j + 1 < m && arr2[j] == arr2[j + 1]) {
                j++;
            }
            // Checks if value of arr1[i] == arr2[j],
            // If true : increments their individual counter and count variable
            if (arr1[i] == arr2[j]) {
                count++;
                i++;
                j++;
            }
            // Checks if value of arr1[i] < arr2[j], If true : increments the i'th counter
            // and count variable
            else if (arr1[i] < arr2[j]) {
                count++;
                i++;
            }
            // Checks if value of arr1[i] > arr2[j], If true : increments the j'th counter
            // and count variable
            else {
                j++;
                count++;
            }
        }
        // If i'th counter is smaller than n, then traverse through remaining elements
        // of arr1 and count them
        while (i < n) {
            while (i + 1 < n && arr1[i] == arr1[i + 1]) {
                i++;
            }
            count++;
            i++;
        }
        // If j'th counter is smaller than n, then traverse through remaining elements
        // of arr2 and count them
        while (j < m) {
            while (j + 1 < m && arr2[j] == arr2[j + 1]) {
                j++;
            }
            count++;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int arr1[] = new int[n];
            for (int i = 0; i < n; i++)
                arr1[i] = scan.nextInt();
            int arr2[] = new int[m];
            for (int i = 0; i < m; i++)
                arr2[i] = scan.nextInt();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            System.out.println(return_union_count(arr1, arr2, n, m));
        }
        scan.close();
    }
}