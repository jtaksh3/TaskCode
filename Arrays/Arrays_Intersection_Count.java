//PROBLEM STATEMENT : Intersection of two arrays count.

import java.util.*;

public class Arrays_Intersection_Count {

    static int intersectionCount(int[] arr1, int arr2[], int n, int m) {
        int i = 0, j = 0, count = 0, flag1 = 0, flag2 = 0;
        while (i < n && j < m) {
            // Increment the i'th counter till the next value in arr1 is different
            while (i + 1 < n && arr1[i] == arr1[i + 1]) {
                i++;
                // Used to check same value in arr1
                flag1 = 1;
            }
            // Increment the j'th counter till the next value in arr2 is different
            while (j + 1 < m && arr2[j] == arr2[j + 1]) {
                j++;
                // Used to check same value in arr1
                flag2 = 1;
            }
            // Checks if value of arr1[i] == arr2[j],
            // If true : increments their individual counter and count variable
            if (arr1[i] == arr2[j]) {
                count++;
                i++;
                j++;
                flag1 = flag2 = 0;
            }
            // Checks if value of arr1[i] < arr2[j], If true : increments the i'th counter
            // and count variable based on flag1
            else if (arr1[i] < arr2[j]) {
                if (flag1 == 1)
                    count++;
                i++;
                flag1 = 0;
            }
            // Checks if value of arr1[i] > arr2[j], If true : increments the j'th counter
            // and count variable based on flag2
            else {
                if (flag2 == 1)
                    count++;
                j++;
                flag2 = 0;
            }
        }
        // If i'th counter is smaller than n, then traverse through remaining elements
        // of arr1 and count them based on flag1
        while (i < n) {
            while (i + 1 < n && arr1[i] == arr1[i + 1]) {
                i++;
                flag1 = 1;
            }
            if (flag1 == 1)
                count++;
            i++;
            flag1 = 0;
        }
        // If j'th counter is smaller than n, then traverse through remaining elements
        // of arr2 and count them based on flag2
        while (j < m) {
            while (j + 1 < m && arr2[j] == arr2[j + 1]) {
                j++;
                flag2 = 1;
            }
            if (flag2 == 1)
                count++;
            j++;
            flag2 = 0;
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
            scan.close();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            System.out.println(intersectionCount(arr1, arr2, n, m));
        }
    }

}
