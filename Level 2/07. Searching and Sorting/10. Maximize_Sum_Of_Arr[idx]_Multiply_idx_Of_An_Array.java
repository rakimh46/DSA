public class Main {

    public static int maximise(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i] * i;
        }
        return sum;
    }

}
