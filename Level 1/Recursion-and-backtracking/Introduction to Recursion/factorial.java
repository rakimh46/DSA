/*
 */
public class factorial {
    public static void main(String[] args) {
        int ans=factorial(5);
        System.out.println(ans);
    }
    public static int factorial(int n) {
        if(n==0) return 1;
        int fact=factorial(n-1);
        fact*=n;
        return fact;
    }
}
