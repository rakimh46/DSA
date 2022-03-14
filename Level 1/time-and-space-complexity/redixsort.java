import java.util.*;

public class redixsort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = { 5, 779, 8, 122, 1, 11, 3, 3, 44, 9, 4, 11 };

        redix(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void redix(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }

        int exp = 1;
        while (exp <= max) {
            count(arr, exp);
            exp = exp * 10;
        }

    }

    public static void count(int[] arr, int exp) {
        // write code

        int[] farr = new int[10];

        // frequency array counting
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i] / exp % 10]++;
        }

        // frequency array counting plus
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }

        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = farr[arr[i] / exp % 10] - 1;
            ans[pos] = arr[i];
            farr[arr[i] / exp % 10]--;
        }

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

}
