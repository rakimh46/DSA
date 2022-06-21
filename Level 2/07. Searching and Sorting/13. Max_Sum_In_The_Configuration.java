import java.util.*;

class Solution {
    public static int maximise(int[] arr) {
        // write your code here
        int sum = 0;
        int temp = 0;
        int s1 = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            s1 += arr[i] * i;
        }

        int ans = s1;
        temp = s1;
        for (int i = 0; i < arr.length; i++) {
            temp = temp + sum - n * (arr[n - 1 - i]);
            ans = Math.max(temp, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}