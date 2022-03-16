public class maxandmin {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 35, 40, 5 };

        System.out.println(max(arr));
        System.out.println(min(arr));

    }

    public static int max(int[] array) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}