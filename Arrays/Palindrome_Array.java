/*PROBLEM STATEMENT : Given a Integer array A[] of n elements. Your task is to complete the function
PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.*/

import java.util.*;

public class Palindrome_Array {

    public static int palinArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int temp = arr[i], rev = 0;

            while (temp > 0) {
                rev += temp % 10;
                temp /= 10;
                if (temp > 0)
                    rev *= 10;
            }
            if (arr[i] != rev)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            sc.close();
            System.out.println(palinArray(a, n));
        }
    }
}
