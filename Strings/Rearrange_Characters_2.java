/*PROBLEM STATEMENT : Given a string S with repeated characters (only lowercase). The task is to rearrange
characters in a string such that no two adjacent characters are same.
Approach 2
*/

import java.util.*;
import java.io.*;

public class Rearrange_Characters_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            boolean result = rearrangeCharacters(str);
            if (result)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    static class Key {
        int freq;
        char ch;

        Key(int freq, char c) {
            this.freq = freq;
            this.ch = c;
        }
    }

    static class KeyComparator implements Comparator<Key> {
        @Override
        public int compare(Key k1, Key k2) {
            return k2.freq - k1.freq;
        }
    }

    private static boolean rearrangeCharacters(String str) {
        final short MAX_CHAR = 26;
        int n = str.length();
        int count[] = new int[MAX_CHAR];

        for (int i = 0; i < n; ++i) {
            count[str.charAt(i) - 'a']++;
        }

        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for (char c = 'a'; c <= 'z'; ++c) {
            int val = c - 'a';
            if (count[val] != 0) {
                pq.add(new Key(count[val], c));
            }
        }

        str = "";
        Key prev = new Key(-1, '$');
        while (pq.size() != 0) {
            Key k = pq.poll();
            str = str + k.ch;
            if (prev.freq > 0)
                pq.add(prev);
            k.freq--;
            prev = k;
        }
        if (n == str.length())
            return true;
        return false;
    }
}
