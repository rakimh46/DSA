//leetcode 724
class Solution {
    public int pivotIndex(int[] arr) {
        int sum=0;
        for(int val:arr){
            sum+=val;
        }
        
        int l=0,r=sum;
        int i=0;
        for(int val:arr){
            r=r-val;
            if(l==r){
                return i;
            }
            l+=val;
            i++;
        }
        return -1;
    }
}