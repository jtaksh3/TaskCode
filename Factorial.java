import java.util.*;

class Factorial {

    static int multiply(int arr[], int x, int arr_size) {
        int carry = 0;
        for (int i = 0; i < arr_size; i++) {
            int mul = arr[i] * x + carry;
            arr[i] = mul % 10;
            carry = mul / 10;
        }
        while (carry != 0) {
            arr[arr_size] = carry % 10;
            carry = carry / 10;
            arr_size++;
        }
        return arr_size;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        int arr[] = new int[n], arr_size = 1;
        arr[0] = 1;

        for (int x = 2; x <= n; x++) {
            arr_size = multiply(arr, x, arr_size);
        }
        for (int i = arr_size - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}