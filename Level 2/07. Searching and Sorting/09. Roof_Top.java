public class Main {

    public static int findMaxSteps(int[] arr) {
        // write your code here
        int i = 0;
        int c = 0;
        int ms = 0;
        while (i < arr.length - 1) {
            if (arr[i] < arr[i + 1]) {
                c++;
            } else {
                if (c > ms) {
                    ms = c;
                }
                c = 0;
            }
            i++;
        }
        if (c > ms) {
            ms = c;
        }
        return ms;
    }

}
