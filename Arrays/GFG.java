/*package whatever //do not write package name here */

import java.util.*;

class GFG {

    static int return_union_count(int[] arr1, int arr2[], int n, int m) {
        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            while (i + 1 < n && arr1[i] == arr1[i + 1]) {
                i++;
            }
            while (j + 1 < m && arr2[j] == arr2[j + 1]) {
                j++;
            }
            if (arr1[i] == arr2[j]) {
                count++;
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                count++;
                i++;
            } else {
                j++;
                count++;
            }
        }
        while (i < n) {
            while (i + 1 < n && arr1[i] == arr1[i + 1]) {
                i++;
            }
            count++;
            i++;
        }
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
            scan.close();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            System.out.println(return_union_count(arr1, arr2, n, m));
        }
    }
}