public class Maxarray {
    public static void main(String[] args) {
        int[] arr = { 11, 22, 33, 40, 15, 56, 87, 18, 99 };
        int ans = display(arr, 0);
        System.out.println(ans);
    }

    public static int display(int[] arr, int n) {
        if (n == arr.length)
            return Integer.MIN_VALUE;

        int max = display(arr, n + 1);
        if (max < arr[n]) {
            return arr[n];
        } else {
            return max;
        }
    }

}
