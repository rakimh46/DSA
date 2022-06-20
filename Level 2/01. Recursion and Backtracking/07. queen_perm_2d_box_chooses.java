import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int N, int row, int col, String asf, boolean[] queens) {
        if(row == N) {
            if(qpsf == N) {
                System.out.println(asf + "\n");
            }
            return;
        }
       
       //yes call
       //which queen to select
       for(int q=0; q < N;q++) {
           if(queens[q] == false) {
               queens[q] = true;
               if(col == N-1) {
                    queensPermutations(qpsf + 1,N,row+1,0,asf + "q" + (q+1) + "\n",queens);
               }
               else {
                   queensPermutations(qpsf + 1,N,row,col+1,asf + "q" + (q+1) + "\t",queens);
               }
               queens[q] = false;
           }
       }
       
       //no call
       if(col == N-1) {
            queensPermutations(qpsf,N,row+1,0,asf + "-\n",queens);
       }
       else {
           queensPermutations(qpsf,N,row,col+1,asf + "-\t",queens);
       }
       
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}