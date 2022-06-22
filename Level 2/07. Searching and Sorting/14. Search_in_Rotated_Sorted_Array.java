class Solution {
    public int search(int[] arr, int target) {
        int lo=0;
        int hi=arr.length-1;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[lo]<=arr[mid]){
                if(target>=arr[lo] && target<arr[mid]){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else if(arr[hi]>=arr[mid]){
                if(target<=arr[hi] && target>arr[mid]){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }
        return -1;
    }
}