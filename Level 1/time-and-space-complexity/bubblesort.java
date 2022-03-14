import java.util.*;

public class bubblesort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        int[] arr = { 5, 9, 8, 2, 1};
        bubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubble(int[] arr) {
        for (int front = 1; front < arr.length; front++) {
            for (int i = 0; i < arr.length - front; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

}
