//PROBLEM STATEMENT : Program to Reverse an Array

import java.util.Scanner;

public class Reverse_Array {

    static boolean reverse_array(int arr[], int size) {
        if(size == 0)
        {
            return false;
        }
        System.out.print(arr[--size]+" ");
        return reverse_array(arr, size);
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
        System.out.println("Enter 1 for Reversed Array using Loop");
        System.out.println("Enter 2 for Reversed Array using Recursion");
        int choice = scan.nextInt();
        scan.close();
        switch(choice) {
            case 1:
            System.out.println("Reversed Array:");
            for(int i = n-1; i > -1; i--) {
                System.out.print(arr[i]+" ");
            }
            break;
            case 2:
            System.out.println("Reversed Array:");
            reverse_array(arr, n);
            break;
            default:
            System.out.println("Wrong Choice Entered.");
        }
    }
    
}
