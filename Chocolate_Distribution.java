/*PROBLEM STATEMENT : The first line of input contains an integer T, denoting the number of test cases.
Then T test cases follow. Each test case consists of three lines. The first line of each test case contains
an integer N denoting the number of packets. Then next line contains N space separated values of the
array A denoting the values of each packet. The third line of each test case contains an integer m denoting
the no of students.*/

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
