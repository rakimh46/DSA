//maximum sum of a subsequence with no adjacent elements

import java.io.*;
import java.util.*;

public class maxsumseqnoadj {

    public static void main(String[] args) throws Exception {
        int[] arr = { 10, 1, 2, 3, 5, 8, 9 };

        int  inc= arr[0];
        int exl=0;

        for (int i = 1; i < arr.length; i++) {
            int incarr=exl+arr[i];
            int exlarr=Math.max(inc, exl);

            inc=incarr;
            exl=exlarr;
        }

        int max=Math.max(inc, exl);
        System.out.println(max);

    }
}