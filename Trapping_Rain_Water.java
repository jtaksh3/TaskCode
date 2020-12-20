/*PROBLEM STATEMENT : Given an array arr[] of N non-negative integers representing height of blocks at
index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks
after raining.*/

import java.io.*;

public class Trapping_Rain_Water {

    static long TrappingWater(int arr[], int n) { 
        int leftMax = 0, rightMax = 0, res = 0;
        int low = 0, high = n-1;
        while(low <= high){
            if(arr[low] < arr[high]){
                if(arr[low] > leftMax){
                    leftMax = arr[low];
                } else {
                    res += leftMax-arr[low];
                }
                low++;
            } else {
                if(arr[high] > rightMax){
                    rightMax = arr[high];
                } else {
                    res += rightMax-arr[high];
                }
                high--;
            }
        }
        return res;
    } 
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    System.out.println(TrappingWater(arr, n));
		}
	}
}