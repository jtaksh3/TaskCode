/*PROBLEM STATEMENT: Given two arrays: arr1[0..m-1] of size m and arr2[0..n-1] of size n. Task is to
check whether arr2[] is a subset of arr1[] or not. Both the arrays can be both unsorted or sorted. It
may be assumed that elements in both array are distinct.*/

import java.util.*;

public class SubSet_of_Array {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- > 0) {
		    int n = scan.nextInt();
		    int m = scan.nextInt();
		    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		    int arr[] = new int[m], count = 0;
		    for(int i = 0; i < n; i++) {
		        int a = scan.nextInt();
		        if(!hm.containsKey(a))
		            hm.put(a, 0);
		        hm.put(a, hm.get(a) + 1);
		    }
		    for(int i = 0; i < m; i++)
                arr[i] = scan.nextInt();
            scan.close();
		    for(int i = 0; i < m; i++) {
		        if(hm.containsKey(arr[i]) && hm.get(arr[i]) > 0) {
		            count++;
		            hm.put(arr[i], hm.get(arr[i]) - 1);
		        } else {
		            break;
		        }
		    }
		    if(count == m)
		        System.out.println("Yes");
		    else
		        System.out.println("No");
		}
	}
}
