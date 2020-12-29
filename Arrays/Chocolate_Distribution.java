/*PROBLEM STATEMENT : Given an array A of positive integers of size N, where each value represents number of
chocolates in a packet. Each packet can have variable number of chocolates. There are M students, the task is
to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates
and student having packet with minimum chocolates is minimum.*/

import java.util.*;
import java.io.*;

public class Chocolate_Distribution {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		        arr[i] = Integer.parseInt(inputLine[i]);
		    int m = Integer.parseInt(br.readLine().trim());
		    Arrays.sort(arr);
		    int min = arr[m - 1] - arr[0];
		    for(int i = 1; i < n && m < n; i++) {
		        min = Math.min(min, arr[m] - arr[i]);
		        m++;
		    }
		    System.out.println(min);
		}
	}
}
