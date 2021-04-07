/* PROBLEM STATEMENT : Given a sorted array having 10 elements which contains 6 different numbers in
which only 1 number is repeated five times. Your task is to find the duplicate number using two comparisons
only.
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
Each test case contains 10 space separated values of the array A[].
*/

import java.io.*;

public class Duplicate_Atmost_Two_Comparisons {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String s[] = br.readLine().trim().split(" ");
			int arr[] = new int[10];
			for (int i = 0; i < 10; i++)
				arr[i] = Integer.parseInt(s[i]);
			if (arr[3] == arr[4])
				System.out.println(arr[3]);
			else if (arr[4] == arr[5])
				System.out.println(arr[4]);
			else
				System.out.println(arr[5]);
		}
	}
}
