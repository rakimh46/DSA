import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[]args) {
        //write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        
        mergeSort(arr,0,n-1);
        System.out.println(count);
		
    }
    
    static int count=0;
    public static int[] MergeTwoSorted(int[] left,int[] right){
        int i=0;
        int j=0;
        int k=0;
        
        int[] merged=new int[left.length + right.length];
        
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                merged[k]=left[i];
                i++;
                k++;
            }else{
                count+=(left.length-i);
                merged[k]=right[j];
                j++;
                k++;
            }
        }
        
        while(i<left.length){
            merged[k]=left[i];
                i++;
                k++;
        }
        
        while(j<right.length){
            merged[k]=right[j];
                j++;
                k++;
        }
        
        return merged;
    }
    public static int[] mergeSort(int[] arr,int lo,int hi){
        if(lo==hi){
            return new int[]{arr[lo]};
        }
        int mid=(lo+hi)/2;
        
        int[] left=mergeSort(arr,lo,mid);
        int[] right=mergeSort(arr,mid+1,hi);
        
        return MergeTwoSorted(left,right);
    }
}