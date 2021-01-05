/*PROBLEM STATEMENT : Given a sequence of strings, the task is to find out the second most repeated
(or frequent) string in the given sequence.
Note: No two strings are the second most repeated, there will be always a single string.*/

import java.io.*;
import java.util.*;

public class Second_Most_Repeated_Sequence {

    static String secFrequent(String arr[], int N) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++) {
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        int count = 0;
        for (Map.Entry<String, Integer> aa : list) {
            if (count == list.size() - 2)
                return aa.getKey();
            count++;
        }
        return "";
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.next();
            System.out.println(secFrequent(arr, n));
        }
        sc.close();
    }
}
