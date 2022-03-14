public class arrayRec {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        display(arr,0);
    }

    public static void display(int[] arr, int m) {
        if (m == arr.length) return;
        System.out.println(arr[m]);
        display(arr, m + 1);

    }

}
