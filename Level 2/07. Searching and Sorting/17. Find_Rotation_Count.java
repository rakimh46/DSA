class Solution {
    public int findrotationcount(int[] nums) {
        int lo=0;
        int hi=nums.length-1;

        if(nums[0]<=nums[hi]){
            return nums[0];
        }

        while(lo<=hi){
            int mid=(lo+hi)/2;

            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }else if(nums[mid]<nums[mid-1]){
                return mid;
            }else if(nums[lo]<=nums[mid]){
                lo=mid+1;
            }else if(nums[mid]<=nums[hi]){
                hi=mid-1;
            }
        }
        return -1;
    }
    
}
