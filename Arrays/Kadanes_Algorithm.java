//PROBLEM STATEMENT : Given an array arr of N integers. Find the contiguous sub-array with maximum sum

import java.util.Scanner;

public class Kadanes_Algorithm {

    static int maxSubarraySum(int a[], int n){
        int max_so_far = a[0]; 
        int curr_max = a[0]; 
        for(int i = 1; i < n; i++) {
            curr_max = Math.max(a[i], curr_max + a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Size of Array");
        int n = scan.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter Elements of Array");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        System.out.println("Maximum Sum = "+ maxSubarraySum(arr, n));
    }
}
