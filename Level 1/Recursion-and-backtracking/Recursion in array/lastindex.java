public class lastindex {
    public static void main(String[] args) {
        int[] arr = { 1, 99, 33, 40, 40, 56, 87, 18, 99 };
        int x = 40;
        int ans = last(arr, arr.length-1, x);
        System.out.println(ans);
    }

    public static int last(int[] arr, int n, int x) {
        if (n==0) {
            return -1;
        }
        if (arr[n] == x) {
            return n;
        }

        int ans=last(arr, n-1, x);
        return ans;
       // return last(arr, n-1, x);

    }

}

