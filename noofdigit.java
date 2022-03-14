import java.util.*;
class noofdigit{
    public static void main(String[] args){
        Scanner sr=new Scanner(System.in);
        System.out.println("enter number");
        int n = sr.nextInt();
        int count=0;
        while(n!=0){

            n=n/10;
            count++;
        }    
        System.out.print(count+"");
        


    }
}