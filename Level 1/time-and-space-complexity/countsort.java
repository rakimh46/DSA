import java.util.*;

public class countsort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = { 5, 9, 8, 2, 1, 11, 3,3, 4,9,4,11 };
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        count(arr, max, min);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void count(int[] arr, int max, int min) {
        // write code

        int range = max - min + 1;
        int[] farr = new int[range];

        // frequency array counting
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            farr[idx]++;
        }

        // frequency array counting plus
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }

        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[val - min];
            int idx = pos - 1;
            ans[idx] = val;
            farr[val - min]--;
        }

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

}
