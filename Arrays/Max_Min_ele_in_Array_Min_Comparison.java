//PROBLEM STATEMENT  : Maximum and minimum of an array using minimum number of comparisons
//Approach 2 :

import java.util.Scanner;

public class Max_Min_ele_in_Array_Min_Comparison {

    static int return_min(int value1, int value2) {
        return value1 < value2 ? value1 : value2;
    }

    static int return_max(int value1, int value2) {
        return value1 > value2 ? value1 : value2;
    }

    static class MinMax {
        int min;
        int max;
    }

    static MinMax return_min_max(int arr[], int start_index, int last_index) {
        MinMax mm = new MinMax();
        MinMax mml = new MinMax();
        MinMax mmr = new MinMax();
        int mid;

        if(start_index == last_index) {
            mm.min = mm.max = arr[start_index];

            return mm;
        } 
        if(start_index + 1 == last_index) {
            mm.min = return_min(arr[start_index], arr[last_index]);
            mm.max = return_max(arr[start_index], arr[last_index]);

            return mm;
        }

        mid = (start_index + last_index)/2;
        mml = return_min_max(arr, start_index, mid);
        mmr = return_min_max(arr, mid+1, last_index);
        mm.min = return_min(mml.min, mmr.min);
        mm.max = return_max(mml.max, mmr.max);

        return mm;
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
        MinMax mm = return_min_max(arr, 0, arr.length - 1);
        System.out.print("Max = "+ mm.max + " Min = "+ mm.min);
        scan.close();
    }
    
}
