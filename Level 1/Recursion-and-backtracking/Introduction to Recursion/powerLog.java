public class powerLog {

    public static void main(String[] args) {
        int ans = pow(2,5);
        System.out.println(ans);
    }

    public static int pow(int x,int n) {
        if (n == 0)
            return 1;
        int pow = pow(x,n/2);
        pow*=pow;
        if(n%2==1){
            pow*=x;
        }
        return pow;
    }
}
