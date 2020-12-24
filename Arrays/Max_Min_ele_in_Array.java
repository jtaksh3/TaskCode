//PROBLEM STATEMENT  : Maximum and minimum of an array using minimum number of comparisons
//Approach 1 :

import java.util.Scanner;

public class Max_Min_ele_in_Array {

    static int return_max(int arr[], int size) {
        if(size == 0) {
            return -2147483648;
        }
        int index = --size;
        return (arr[index] > return_max(arr, size) ? arr[index] : return_max(arr, size));
    }

    static int return_min(int arr[], int size) {
        if(size == 0) {
            return 2147483647;
        }
        int index = --size;
        return (arr[index] < return_min(arr, size) ? arr[index] : return_min(arr, size));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = scan.nextInt();
        System.out.println("Enter elements of Array:");
        int arr[] = new int[n], max = -2147483648, min = 2147483647;
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter 1 for Max and Min Elements using Loop");
        System.out.println("Enter 2 for Max and Min Elements using Recursion");
        int choice = scan.nextInt();
        scan.close();
        switch(choice) {
            case 1:
            for(int i = 0; i < n; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                }
                if(arr[i] < min) {
                    min = arr[i];
                }
            }
            System.out.print("Max = "+ max + " Min = "+ min);
            break;
            case 2:
            System.out.print("Max = "+ return_max(arr, arr.length) + " Min = "+ return_min(arr, arr.length));
            break;
            default:
            System.out.println("Wrong Choice Entered.");
        }
    }
}
