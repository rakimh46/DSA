import java.util.*;

public class lastoccur {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x=scn.nextInt();
        System.out.println(lastoccur(arr, 0,x));
    
    }

    public static int lastoccur(int[] arr, int n, int x) {
        if (arr.length == n)
            return -1;

        int res = lastoccur(arr, n + 1, x);

        if (res == -1) {
            if (arr[n] == x) {
                res = n;
            }
        }
        return res;

    }
}