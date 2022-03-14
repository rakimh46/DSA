public class firstoccur {
    public static void main(String[] args) {
        int[] arr = { 1, 99, 33, 40, 40, 56, 87, 18, 99 };
        int x = 40;
        int ans = first(arr, 0, x);
        System.out.println(ans);
    }

    public static int first(int[] arr, int n, int x) {
        if (arr.length == n) {
            return -1;
        }
        if (arr[n] == x) {
            return n;
        }

        // int ans=first(arr, n+1, x);
        // return ans;
        return first(arr, n + 1, x);

    }

}
