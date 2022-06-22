// duplicate
class Solution {
    public int findMin(int[] nums) {
        int pivot=findPivot(nums);
        if (pivot==-1) return nums[0];
        else return nums[pivot];
    }
        public int findPivot(int[] nums){
	        int start=0, end=nums.length-1;
	     while(start<end){
	        int mid=start+(end-start)/2;
	        if(mid <end && nums[mid]>nums[mid+1]){  
	            return mid+1;
	        }
	        if(mid > start && nums[mid-1]>nums[mid]){
	            return mid;
	        }
	        if(nums[start]==nums[mid] && nums[end]==nums[mid]){            
	            if(nums[start]>nums[start+1]){
	                return start+1;
	            }
	            start++;
	            if(nums[end]<nums[end-1]){
	                return end;
	            }
	            end--;
	        }
	        else if(nums[start]<nums[mid]|| (nums[start]==nums[mid] && nums[mid]>nums[end])){
	            start=mid+1;
	        }
	        else{
	            end=mid-1;
	        }
	        
	    }
	    return -1;
	    }
        
    
}
