/* PROBLEM STATEMENT : Given an array of size n and a number k, find all elements that appear more than
n/k times*/

import java.util.*;

public class Elements_Occurence_nk {

    static class eleCount {
        int e;
        int c;
    };

    static void moreThanNdK(int arr[], int n, int k) {
        if (k < 2)
            return;

        eleCount[] temp = new eleCount[k - 1];
        for (int i = 0; i < k - 1; i++)
            temp[i] = new eleCount();
        for (int i = 0; i < k - 1; i++) {
            temp[i].c = 0;
        }
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < k - 1; j++) {
                if (temp[j].e == arr[i]) {
                    temp[j].c += 1;
                    break;
                }
            }
            if (j == k - 1) {
                int l;
                for (l = 0; l < k - 1; l++) {
                    if (temp[l].c == 0) {
                        temp[l].e = arr[i];
                        temp[l].c = 1;
                        break;
                    }
                }
                if (l == k - 1)
                    for (l = 0; l < k - 1; l++)
                        temp[l].c -= 1;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            int ac = 0;
            for (int j = 0; j < n; j++)
                if (arr[j] == temp[i].e)
                    ac++;
            if (ac > n / k)
                System.out.print("Number:" + temp[i].e + " Count:" + ac + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        scan.close();
        moreThanNdK(arr, n, k);
    }

}
