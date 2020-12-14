//PROBLEM STATEMENT  : Maximum and minimum of an array using minimum number of comparisons
//Approach 3 :

import java.util.Scanner;

public class Max_Min_ele_in_Array_Min_Comparison_2 {

    static int return_min(int value1, int value2) {
        return value1 < value2 ? value1 : value2;
    }

    static int return_max(int value1, int value2) {
        return value1 > value2 ? value1 : value2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = scan.nextInt();
        System.out.println("Enter elements of Array:");
        int arr[] = new int[n], min, max, itr;
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        if (n == 1) {
            min = max = arr[0];
        } else if (n == 2) {
            min = return_min(arr[0], arr[1]);
            max = return_max(arr[0], arr[1]);
        } else {
            if (n % 2 == 0) {
                min = return_min(arr[0], arr[1]);
                max = return_max(arr[0], arr[1]);
                itr = 2;
            }
            else {
                min = max = arr[0];
                itr = 1;
            }
            while(itr < n - 1) {
                if(arr[itr] > arr[itr + 1]) {
                    min = return_min(arr[itr + 1], min);
                    max = return_max(arr[itr], max);
                }
                else {
                    min = return_min(arr[itr], min);
                    max = return_max(arr[itr + 1], max);
                }
                itr += 2;
            }
        }
        System.out.print("Max = " + max + " Min = " + min);
        scan.close();
    }
    
}
