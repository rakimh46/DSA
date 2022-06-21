class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        int lo=findCrossOver(arr,0,arr.length-1,x);
        int hi=lo+1;
        while(lo>=0 && hi<arr.length && k-->0){
            if(Math.abs(x-arr[lo])<=Math.abs(arr[hi]-x)){
                ans.add(arr[lo]);
                lo--;
            }else{
                ans.add(arr[hi]);
                hi++;
            }
        }
        
        while(lo>=0 && k-->0){
            ans.add(arr[lo]);
            lo--;
        }
        
        while(hi<arr.length && k-->0){
            ans.add(arr[hi]);
            hi++;
        }
        Collections.sort(ans);
        return ans;
    }
    public int findCrossOver(int[] arr,int lo,int hi,int x){
        if(arr[hi]<=x){
            return hi;
        }
        if(arr[lo]>x){
            return lo;
        }
        int mid = (lo + hi) / 2;
        if (arr[mid] <= x && arr[mid + 1] > x) 
            return mid;

        else if (arr[mid] < x) 
            return findCrossOver(arr, mid + 1, hi, x);
        
        else
            return findCrossOver(arr, lo, mid - 1, x);
    }
}