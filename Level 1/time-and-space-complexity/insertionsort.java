import java.util.*;

public class insertionsort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] arr = { 5, 9, 8, 2, 1, 11, 0};
        bubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubble(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }else{
                    break;
                }
            }
        }
    }

}

