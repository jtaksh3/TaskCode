import java.util.*;

public class Voting_in_Siruseri
{
    public static void mergeArrays(int arr1[], int arr2[], int arr3[], int arr4[], int arr5[], int a, int b, int c, int d, int e, int merged[]) {
        int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0;

        while (i<a && j<b && k<c && l<d && m<e) {
            if (arr1[i] < arr2[j] && arr1[i] < arr3[k] && arr1[i] < arr4[l]  && arr1[i] < arr5[m])
                merged[n++] = arr1[i++];
            else if (arr2[j] < arr3[k] && arr2[j] < arr4[l]  && arr2[j] < arr5[m])
                merged[n++] = arr2[j++];
            else if (arr3[k] < arr4[l]  && arr3[k] < arr5[m])
                merged[n++] = arr3[k++];
            else if (arr4[l] < arr5[m])
                merged[n++] = arr4[l++];
            else
                merged[n++] = arr5[m++];
        }

        while (i < a)
            merged[n++] = arr1[i++];
        while (j < b)
            merged[n++] = arr2[j++];
        while (k < c)
            merged[n++] = arr3[k++];
        while (l < d)
            merged[n++] = arr4[l++];
        while (m < e)
            merged[n++] = arr5[m++];
    }

    public static void main (String[]args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();

        int[] arr = new int[a];
        int[] barr = new int[b];
        int[] carr = new int[c];
        int[] dar = new int[d];
        int[] ear = new int[e];

        int[] merged = new int[a+b+c+d+e];

        for(int i = 0; i < a; i++)
            arr[i] = scan.nextInt();
        for(int i = 0; i < b; i++)
            barr[i] = scan.nextInt();
        for(int i = 0; i < c; i++)
            carr[i] = scan.nextInt();
        for(int i = 0; i < d; i++)
            dar[i] = scan.nextInt();
        for(int i = 0; i < e; i++)
            ear[i] = scan.nextInt();
        scan.close();

        Arrays.sort(arr);
        Arrays.sort(barr);
        Arrays.sort(carr);
        Arrays.sort(dar);
        Arrays.sort(ear);

        mergeArrays(arr, barr, carr, dar, ear, a, b, c, d, e, merged);

        int counter = 0;

        int i = 0;
        while(i < merged.length){
            int count = 1;
            int j = i + 1;
            while (j != merged.length && merged[i] == merged[j]) {
                count++;
                j++;
            }
            if(count >= 3)
                counter++;
            i = j;
        }
        System.out.println(counter);
    }
}
