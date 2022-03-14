public class prog {

    public static void main(String[] args) {
        pow(6);

    }

    public static void pow(int n) {
        if (n > 0) {
            System.out.print(n+" ");
            pow(n - 1);
            pow(n - 2);
            pow(n - 3);
        }
    }
}
