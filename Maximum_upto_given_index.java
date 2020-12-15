/*PROBLEM STATEMENT : Given an array of integers where each element represents the max number of steps
that can be made forward from that element. Write a function to return the minimum number of jumps to
reach the end of the array (starting from the first element). If an element is 0, then cannot move through
that element. */
//BY AAKASH CHOUDHARY

import java.util.Scanner;

public class Maximum_upto_given_index {

    static int maximum(int arr[], int i, int n) {
        int max = arr[n - 1], index = n - 1;
        while(i < n - 1) {
            if((arr[i] + i) > (arr[i + 1] + i + 1) && (arr[i] + i) > (max + index)) {
                max = arr[i];
                index = i;
            }
            else if((arr[i] + i) < (arr[i + 1] + i + 1) && (arr[i + 1] + i + 1) > (max + index)) {
                max = arr[i + 1];
                index = i + 1;
            }
            i += 2;
        }
        return index;
    }

    static int minJumps(int[] arr){
        int n = arr.length;
        int prev_itr = 1, itr = arr[0], count = 1, i = 1;
        if(arr[0] == 0)
            return -1;
        while(i < n) {
            if(itr >= n - 1)
                return count;
            i = maximum(arr, prev_itr, itr + 1);
            prev_itr = itr;
            if(arr[i] == 0)
                return -1;
            itr = i + arr[i];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = scan.nextInt();
        System.out.println("Enter elements of Array:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(minJumps(arr));
    }
}
