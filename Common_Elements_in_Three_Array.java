import java.util.*;

public class Common_Elements_in_Three_Array {

    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        while ((i < n1 && j < n2) && k < n3) {
            while (i + 1 < n1 && A[i] == A[i + 1]) {
                i++;
            }
            while (j + 1 < n2 && B[j] == B[j + 1]) {
                j++;
            }
            while (k + 1 < n3 && C[k] == C[k + 1]) {
                k++;
            }
            if (A[i] == B[j] && B[j] == C[k]) {
                al.add(A[i]);
                i++;
                j++;
                k++;
            } else if (A[i] < B[j] && A[i] < C[k]) {
                i++;
            } else if (A[i] > B[j] && B[j] < C[k]) {
                j++;
            } else if (C[k] < B[j] && A[i] > C[k]) {
                k++;
            } else if (A[i] == B[j]) {
                if (A[i] < C[k]) {
                    i++;
                    j++;
                } else {
                    k++;
                }
            } else if (A[i] == C[k]) {
                if (A[i] < B[j]) {
                    i++;
                    k++;
                } else {
                    j++;
                }
            } else if (C[k] == B[j]) {
                if (A[i] > C[k]) {
                    k++;
                    j++;
                } else {
                    i++;
                }
            }
        }
        return al;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();

            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];

            for (int i = 0; i < n1; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < n2; i++) {
                B[i] = sc.nextInt();
            }
            for (int i = 0; i < n3; i++) {
                C[i] = sc.nextInt();
            }

            ArrayList<Integer> res = commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0) {
                System.out.print(-1);
            } else {
                for (int i = 0; i < res.size(); i++) {
                    System.out.print(res.get(i) + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
