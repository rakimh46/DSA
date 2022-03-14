public class printzigzag {
    public static void main(String[] args) {
        zigzag(4);

    }
    public static void zigzag(int n){
        if(n==0) return;
        System.out.print(n+" ");
        zigzag(n-1);
        System.out.print(n+" ");
        zigzag(n-1);
        System.out.print(n+" ");
        
    }
}
