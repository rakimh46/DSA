public class allindicies {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 4, 1, 4, 3, 4, 8, 4 };
        int x = 4;
        int[] ans = indices(arr, x, 0, 0);
        if (ans.length != 0) {
            for (int val : ans) {
                System.out.println(val);
            }

        }
    }

    // fsf=frequency so far
    public static int[] indices(int[] arr, int x, int n, int fsf) {
        if (arr.length == n) {
            int[] base = new int[fsf];
            return base;
        }
        int res[];
        if (arr[n] == x) {
            res = indices(arr, x, n + 1, fsf + 1);
            res[fsf] = n;
        } else {
            res = indices(arr, x, n + 1, fsf);
        }

        return res;
    }
}
